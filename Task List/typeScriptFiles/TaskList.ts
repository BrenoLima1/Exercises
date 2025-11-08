import { Task } from "./Task";

export class TaskList {
    private tasks: Task[] = [];

    public addTask(task: Task) {
        this.tasks.push(task);
    }

    public getTasks(): Task[] {
        return this.tasks;
    }

    public getTaskById(id: number): Task | undefined {
        return this.tasks.find(task => task.getId() === id);
    }

    public deleteTaskById(id: number) {
        this.tasks = this.tasks.filter(task => task.getId() !== id);
    }

    public updateTask(task: Task) {
        const index = this.tasks.findIndex(t => t.getId() === task.getId());
        if (index !== -1) {
            this.tasks[index] = task;
        }
    }

    public markTaskAsCompleted(id: number) {
        const task = this.getTaskById(id);
        if (task) {
            task.setCompleted(true);
        }
    }
}
