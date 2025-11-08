export class Task {
    public id: number;
    public title: string;
    public description: string;
    public completed: boolean;
    public date: Date;

    public getId(): number {
        return this.id;
    }
    public setId(value: number) {
        this.id = value;
    }

    public getTitle(): string {
        return this.title;
    }
    public setTitle(value: string) {
        this.title = value;
    }

    public getDescription(): string {
        return this.description;
    }
    public setDescription(value: string) {
        this.description = value;
    }

    public getCompleted(): boolean {
        return this.completed;
    }
    public setCompleted(value: boolean) {
        this.completed = value;
    }

    public getDate(): Date {
        return this.date;
    }
    public setDate(value: Date | null) {
        this.date = value ? value : new Date();
    }

    constructor(id: number, title: string, description: string, completed: boolean, date: Date) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.completed = completed;
        this.date = date;
    }

    public toString(): string {
        return `ID: ${this.id}, title: ${this.title}, description: ${this.description}, completed: ${this.completed}, date: ${this.date}`;
    }

}
