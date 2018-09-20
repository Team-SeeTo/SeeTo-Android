package seeto.c2.artoria.us.myapplication.Model;

import java.util.ArrayList;

public class TodoMainModel {
    String title, type, createdAt, expiration;
    Boolean isCompleted;
    ArrayList<Milestone> milestones = new ArrayList<>();

    public static class Milestone {
        private String name;
        private Boolean isCompleted;
        Milestone(String name, Boolean isCompleted) {
            this.name = name;
            this.isCompleted = isCompleted;
        }

        public String getName() {
            return name;
        }

        public Boolean getCompleted() {
            return isCompleted;
        }
    }
}
