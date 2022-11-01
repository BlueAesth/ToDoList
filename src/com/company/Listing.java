package com.company;
import java.util.Date;

public class Listing {
        //Listing object's attributes

    //Need name, description, date released, rating, run time, cast
        public String title;
        public String desc;
        public Date created;
        public boolean completed;
        public Date dCompleted;

        public Listing() {} //Empty constructor

    //Getters and Setters
        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) { this.desc = desc; }

        public Date getCreated() {
            return created;
        }

        public void setCreated(Date created) {
            this.created = created;
        }

    public void setCompleted(boolean completed) {
            this.completed = completed;
        }

    public void setdCompleted(Date dCompleted) {
            this.dCompleted = dCompleted;
        }

        //toString Override of a listing objects
        @Override
        public String toString() {
            String strCompleted;
            String strDCompleted;

            if (!completed){
                strCompleted = "No";
                strDCompleted = "Not Completed";
            }
            else {
                strCompleted = "Yes";
                strDCompleted = String.valueOf(dCompleted);
            }

            return  title + "\n" +
                    "Description: " + desc + "\n" +
                    "Date Created: " + created + "\n" +
                    "Completed: " + strCompleted + "\n" +
                    "Date Completed: " + strDCompleted + "\n";
        }
    }