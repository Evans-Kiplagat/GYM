package com.example.gym;

import java.util.ArrayList;

public class utils {
    private static ArrayList<Model> Trainings;
    private static ArrayList<plan> plans;

    public static  void initTrainings(){
        if (null == Trainings){
            Trainings =  new ArrayList<>();

            Model pushUp = new Model(1,"PUSH_UPS","Begin in a downward dog yoga position, with your ","","https://media.gettyimages.com/photos/athletic-man-doing-push-ups-outdoors-on-wooden-floor-by-the-river-picture-id677708774?k=6&m=677708774&s=612x612&w=0&h=bUWr893Cfj_LYJ7jYr0aI7Xhi7rWtPt3Yembc7GDouQ=");
                Trainings.add(pushUp);
           Model situps = new Model(2,"SIT_UP","this is a modern sikt up trend","","https://media.gettyimages.com/photos/japanese-man-doing-pushups-picture-id467456456?k=6&m=467456456&s=612x612&w=0&h=lFzQnglLi5wU72yVxy61mroR00pA71VIg-NMVZIdj0Y=");
                Trainings.add(situps);
            Model jogs = new Model(3,"JOGGINGS","","","https://media.gettyimages.com/photos/young-athletic-man-exercising-in-the-winter-picture-id1208310894?k=6&m=1208310894&s=612x612&w=0&h=HRsjGsMiDY9nq88BSMzAkTuZxs62JAQHhqg7P9gF7HU=");
                 Trainings.add(jogs);
             Model jumpups = new Model(4,"JUMP_UPS","","","https://media.gettyimages.com/photos/athletic-man-doing-flying-push-ups-outdoors-picture-id520832400?k=6&m=520832400&s=612x612&w=0&h=H_Wv4RFD-jxgl8F-1K2KPidJsgThrcPrcTpnI6ZtdT4=");
                     Trainings.add(jumpups);
        }
    }

    public static ArrayList<Model> getTrainings() {
        return Trainings;
    }

    public static Boolean Addplan(plan plan){
        if (null ==plans){
            plans= new ArrayList<>();

        }
        return  plans.add(plan);
    }
}
