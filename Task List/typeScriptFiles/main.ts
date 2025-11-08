import * as readline from "readline";
import { Task } from "./Task";
import { TaskList } from "./TaskList";

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

const taskList = new TaskList();
let nextId = 1;

function menu(): void {
  console.log("\n--- MENU ---");
  console.log("1. Add task");
  console.log("2. List tasks");
  console.log("3. Mark task as completed");
  console.log("4. Delete task");
  console.log("5. Update task");
  console.log("6. Exit");

  rl.question("Choose an option: ", (option: string) => {
    switch (option) {
      case "1":
        addTask();
        break;
      case "2":
        listTasks();
        break;
      case "3":
        markAsCompleted();
        break;
      case "4":
        deleteTask();
        break;
      case "5":
        updateTask();
        break;
      case "6":
        rl.close();
        break;
      default:
        console.log("❌ Invalid option.");
        menu();
    }
  });
}

function addTask(): void {
  rl.question("Title: ", (title: string) => {
    rl.question("Description: ", (description: string) => {
      rl.question("Date (dd/mm/yyyy): ", (dateStr: string) => {
        const [day, month, year] = dateStr.split("/").map(Number);
        const date = new Date(year, month - 1, day);
        const task = new Task(nextId++, title, description, false, date);
        taskList.addTask(task);
        console.log("✅ Task added!");
        menu();
      });
    });
  });
}

function listTasks(): void {
  const tasks = taskList.getTasks();
  if (tasks.length === 0) {
    console.log("No tasks registered.");
  } else {
    tasks.forEach(t => {
      console.log(t.toString());
    });
  }
  menu();
}

function markAsCompleted(): void {
  rl.question("Task ID: ", (idStr: string) => {
    const id = parseInt(idStr);
    const task = taskList.getTaskById(id);
    if (!task) {
      console.log("❌ Task not found.");
      return menu();
    }else{
        taskList.markTaskAsCompleted(id);
        console.log("✅ Task marked as completed.");
        menu();
    }
  });
}

function deleteTask(): void {
  rl.question("Task ID: ", (idStr: string) => {
    const id = parseInt(idStr);
    const task = taskList.getTaskById(id);
    if (!task) {
      console.log("❌ Task not found.");
      return menu();
    }else{
        taskList.deleteTaskById(id);
        console.log("🗑️ Task deleted.");
        menu();
    }
  });
}

function updateTask(): void {
  rl.question("Task ID: ", (idStr: string) => {
    const id = parseInt(idStr);
    const task = taskList.getTaskById(id);
    if (!task) {
      console.log("❌ Task not found.");
      return menu();
    }

    rl.question(`New title (${task.getTitle()}): `, (title: string) => {
      rl.question(`New description (${task.getDescription()}): `, (description: string) => {
        rl.question(`New date (dd/mm/yyyy) [${task.getDate().toLocaleDateString()}]: `, (dateStr: string) => {
          const [day, month, year] = dateStr.split("/").map(Number);
          const date = new Date(year, month - 1, day);
          task.setTitle(title || task.getTitle());
          task.setDescription(description || task.getDescription());
          task.setDate(date || task.getDate());
          taskList.updateTask(task);
          console.log("✏️ Task updated.");
          menu();
        });
      });
    });
  });
}

menu();
