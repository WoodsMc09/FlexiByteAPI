package dev.flexibyte.flexibyteapi;

public class Decoder {

    public static String ninetyThree(){
        String a = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z ";
        String[] list = a.split(" ");

        String f = "";

        for(String s : list){
            if(s.equalsIgnoreCase(list[1])){
                f = s.toLowerCase() + " ";
            }

            if(s.equalsIgnoreCase(list[5])){
                f = s.toLowerCase() + "213";
            }
        }

        f = f.replace("213", "45");

        return f.replace("45", "");
    }

    public static String seven(){
        String a = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z ";
        String[] list = a.split(" ");

        String f = "";

        for(String s : list){
            if(s.equalsIgnoreCase(list[9])){
                f = s.toLowerCase() + " ";
            }

            if(s.equalsIgnoreCase(list[5])){
                f = s.toLowerCase() + "12";
            }

            if(s.equalsIgnoreCase(list[11])){
                f = s.toLowerCase() + "94";
            }
        }

        f = f.replace("94", "pae");

        return f.replace("pae", "");
    }

    public static String D(){
        String a = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z ";
        String[] list = a.split(" ");

        String f = "";

        for(String s : list){
            if(s.equalsIgnoreCase(list[8])){
                f = s.toLowerCase() + " ";
            }

            if(s.equalsIgnoreCase(list[10])){
                f = s.toLowerCase() + "fe";
            }

            if(s.equalsIgnoreCase(list[1])){
                f = s.toUpperCase() + "la";
            }
        }

        f = f.replace("la", "109");

        return f.replace("109", "");
    }

    public static String twelve(){
        String a = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z ";
        String[] list = a.split(" ");

        String f = "";

        for(String s : list){
            if(s.equalsIgnoreCase(list[19])){
                f = s.toLowerCase() + " 12";
            }

            if(s.equalsIgnoreCase(list[1])){
                f = s.toLowerCase() + "dch3";
            }

            if(s.equalsIgnoreCase(list[6])){
                f = s.toUpperCase() + "alsikfd";
            }

            if(s.equalsIgnoreCase(list[5])){
                f = s.toUpperCase() + "192ksa";
            }
        }

        f = f.replace("192ksa", "01jd");

        return f.replace("01jd", "");
    }

    public static String a(){
        String a = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z ";
        String[] list = a.split(" ");

        String f = "";

        for(String s : list){
            if(s.equalsIgnoreCase(list[21])){
                f = s.toLowerCase() + "ndsf1";
            }

            if(s.equalsIgnoreCase(list[23])){
                f = s.toLowerCase() + "kwfj1";
            }

        }

        f = f.replace("kwfj1", "129ed");

        return f.replace("129ed", "");
    }

    public static String Twelve(){
        String a = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z ";
        String[] list = a.split(" ");

        String f = "";

        for(String s : list){
            if(s.equalsIgnoreCase(list[18])){
                f = s.toLowerCase() + " 12*";
            }

            if(s.equalsIgnoreCase(list[4])){
                f = s.toLowerCase() + "dch*3";
            }

            if(s.equalsIgnoreCase(list[6])){
                f = s.toUpperCase() + "sadfe";
            }

            if(s.equalsIgnoreCase(list[24])){
                f = s.toUpperCase() + "192ksa";
            }
        }

        f = f.replace("192ksa", "02je");

        return f.toLowerCase().replace("02je", "");
    }

    public static String one(){
        String a = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z ";
        String[] list = a.split(" ");

        String f = "";

        for(String s : list){
            if(s.equalsIgnoreCase(list[18])){
                f = s.toLowerCase() + " 12*";
            }

            if(s.equalsIgnoreCase(list[4])){
                f = s.toLowerCase() + "dch*3";
            }

            if(s.equalsIgnoreCase(list[6])){
                f = s.toUpperCase() + "sadfe";
            }

            if(s.equalsIgnoreCase(list[8])){
                f = s.toUpperCase() + "192ksa";
            }
        }

        f = f.replace("192ksa", "02je");

        return f.toLowerCase().replace("02je", "");
    }

    public static String k(){
        String a = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z ";
        String[] list = a.split(" ");

        String f = "";

        for(String s : list){
            if(s.equalsIgnoreCase(list[18])){
                f = s.toLowerCase() + " 12*";
            }

            if(s.equalsIgnoreCase(list[4])){
                f = s.toLowerCase() + "dch*3";
            }

            if(s.equalsIgnoreCase(list[6])){
                f = s.toUpperCase() + "sadfe";
            }

            if(s.equalsIgnoreCase(list[8*2+3])){
                f = s.toUpperCase() + "192ksa";
            }
        }

        f = f.replace("192ksa", "02je");

        return f.toLowerCase().replace("02je", "");
    }

    public static String nine(){
        String a = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z ";
        String[] list = a.split(" ");

        String f = "";

        for(String s : list){
            if(s.equalsIgnoreCase(list[18])){
                f = s.toLowerCase() + " 12*";
            }

            if(s.equalsIgnoreCase(list[4])){
                f = s.toLowerCase() + "dch*3";
            }

            if(s.equalsIgnoreCase(list[6])){
                f = s.toUpperCase() + "sadfe";
            }

            if(s.equalsIgnoreCase(list[4])){
                f = s.toUpperCase() + "192ksa";
            }
        }

        f = f.replace("192ksa", "02je");

        return f.toLowerCase().replace("02je", "");
    }

}
