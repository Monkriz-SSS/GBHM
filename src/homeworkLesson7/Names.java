package homeworkLesson7;

public class Names {

    public static String randomName (){

        int [] firstChar = new int[]{66,67,68,70,71,72,74,75,76,77,78,80,81,82,83,84,86,87,88,90};
        int [] vowelChar = new int[]{97,101,105,111,117,121};
        int [] consonantChar = new int[] {98,99,100,102,103,104,106,107,108,109,110,112,113,114,115,116,118,119,120,122};

        char [] name = new char[6];
        name[0]= (char) firstChar[(int) (Math.random()*firstChar.length-1)];
        name[1]= (char) vowelChar[(int) (Math.random()*vowelChar.length-1)];
        name[2]= (char) consonantChar[(int) (Math.random()*consonantChar.length-1)];
        name[3]= (char) vowelChar[(int) (Math.random()*vowelChar.length-1)];
        name[4]= (char) consonantChar[(int) (Math.random()*consonantChar.length-1)];
        name[5]= (char) vowelChar[(int) (Math.random()*vowelChar.length-1)];

        String resultName="";
        for (int i = 0; i < name.length; i++) {
            resultName+= name[i];
        }
        return resultName;
        }

    }

