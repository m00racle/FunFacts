package com.idegroup.funfacts;

import java.util.Random;

/*This class is created to manage available stored facts and the mechanism to randomly selected it!*/
class FactBook {
    /*Fields:*/
    /*Adding all available facts:*/
    private String[] facts = {
            "Ants stretch when they wake up in the morning.",
            "Ostriches can run faster than horses.",
            "Olympic gold medals are actually made mostly of silver.",
            "You are born with 300 bones; by the time you are an adult you will have 206.",
            "It takes about 8 minutes for light from the Sun to reach Earth.",
            "Some bamboo plants can grow almost a meter in just one day.",
            "The state of Florida is bigger than England.",
            "Some penguins can leap 2-3 meters out of the water.",
            "On average, it takes 66 days to form a new habit.",
            "Mammoths still walked the earth when the Great Pyramid was being built.",
            "Treehouse is not actually in a tree."
    };

    /*Methods:*/

    public String getFact() {

        /*We need to set randomness using random number generator:*/

        Random randomGenerator = new Random();/*<- this is the random number generator*/

        int randomNumber = randomGenerator.nextInt(facts.length);/*<- store random generated int in respect
                dynamically with the length of the facts array!*/

        return facts[randomNumber];/*<- we set the fact to be displayed by addressing the index in facts*/
    }
}
