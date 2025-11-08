<?php

require_once('Task.php');
class TaskList
{
    private $tasks = [];

    public function addTask(Task $task)
    {
        $this->tasks[] = $task;
    }

    public function getTasks()
    {
        return $this->tasks;
    }

    public function removeTask(int $id)
    {
        foreach ($this->tasks as $key => $task) {
            if ($task->getId() == $id) {
                unset($this->tasks[$key]);
            }
        }
    }

    public function listTasks()
    {
        foreach ($this->tasks as $task) {
            echo $task->__toString() . PHP_EOL;
        }
    }
}

$taskList = new TaskList();

while (true) {
    echo "1. Add task" . PHP_EOL;
    echo "2. Remove task" . PHP_EOL;
    echo "3. List tasks" . PHP_EOL;
    echo "4. Complete task" . PHP_EOL;
    echo "5. Exit" . PHP_EOL;
    echo "Enter your choice: ";
    $choice = readline();
    if ($choice == 1) {
        echo "Enter task name: ";
        $name = readline();
        echo "Enter task description: ";
        $description = readline();
        $id = count($taskList->getTasks()) + 1;
        $task = new Task($id, $name, $description, false);
        $taskList->addTask($task);
    } elseif ($choice == 2) {
        echo "Enter task id: ";
        $id = readline();
        $taskList->removeTask($id);
    } elseif ($choice == 3) {
        $taskList->listTasks();
    } elseif ($choice == 4) {
        echo "Enter task id: ";
        $id = readline();
        foreach ($taskList->getTasks() as $task) {
            if ($task->getId() == $id) {
                $task->setCompleted(true);
            }
        }
    } elseif ($choice == 5) {
        break;
    }
}
