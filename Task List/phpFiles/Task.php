<?php
class Task{
    public int $id;
    public string $name;
    public string $description;
    public bool $completed ;
    public DateTime $createdAt;

    public function getCreatedAt(): DateTime {
        return $this->createdAt;
    }

    public function setCreatedAt(?DateTime $createdAt = null): void {
        $this->createdAt = $createdAt ?? new DateTime();
    }

    public function getId(): int {
        return $this->id;
    }

    public function setId(int $id): void {
        $this->id = $id;
    }

    public function getName(): string {
        return $this->name;
    }

    public function setName(string $name): void {
        $this->name = $name;
    }

    public function getDescription(): string {
        return $this->description;
    }

    public function setDescription(string $description): void {
        $this->description = $description;
    }

    public function getCompleted(): bool {
        return $this->completed;
    }

    public function setCompleted(bool $completed): void {
        $this->completed = $completed;
    }

    public function __construct(int $id, string $name, string $description, bool $completed){
        $this->id = $id;
        $this->name = $name;
        $this->description = $description;
        $this->completed = $completed;
        $this->setCreatedAt();
    }

    public function __toString(){
        return "Task [id = " . $this->id . ", name = " . $this->name . ", description = " .
         $this->description . ", createdAt = " . $this->createdAt->format('Y-m-d H:i:s') .
         ", completed = " . ($this->completed ? "YES" : "NO" ). "]";
    }
}



?>
