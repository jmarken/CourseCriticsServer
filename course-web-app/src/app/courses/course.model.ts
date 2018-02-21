export class Course {
    public name: string;
    public school: string;
    public avgDifficulty: number;
    public avgQuality: number;
    public avgRelevance: number;
    public avgTeaching: number;

    constructor(name: string, school: string, avgDifficulty: number, avgQuality: number, avgRelevance, avgTeaching) {
        this.name = name;
        this.school = school;
        this.avgDifficulty = avgDifficulty;
        this.avgQuality = avgDifficulty;
        this.avgRelevance = avgRelevance;
        this.avgTeaching = avgTeaching;
    }
}
