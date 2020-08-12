public static void sendCmdlet(String cmdlet){

<<<<<<< HEAD
        //define variables
        String[] commandArray = command.split(" ");
        String cmdlet = commandArray[2];
        String line = "";

        /*
        send the command to the terminal - this page helped a lot when writing this: https://bit.ly/33PZjlB
        be sure to dictate whether the terminal should stay open on windows with the cmd interpreter
                https://bit.ly/3gUhHgH */
=======
        //send the command to the terminal - this page helped a lot: https://bit.ly/33PZjlB
        Process proc = null;        //define the variable outside the try-catch to avoid IDE complaints
>>>>>>> a7f4efb8f504ba01baffc83af09b11d49846f47b
        try {
        Process proc = Runtime.getRuntime().exec(command);

        // Read the output
        BufferedReader reader =
            new BufferedReader(new InputStreamReader(proc.getInputStream()));
        try {
            while ((line = reader.readLine()) != null) {
            System.out.print(line + "\n");
            }// end while ((line = reader.readLine()) != null)
        }catch (Exception e){
            System.out.printf("failed to read input stream from %s%n",cmdlet);
        }// end try-catch while ((line = reader.readLine()) != null)

        try {
            proc.waitFor();
        }catch (Exception e){
            System.out.printf("proc.waitfor() of %s failed%n",cmdlet);
        }//end try-catch proc.waitFor();

<<<<<<< HEAD
        }catch (Exception e){
            System.out.printf("attempted cmdlet \"%s\" failed%n",cmdlet);
        }//end Process proc = Runtime.getRuntime().exec(command)
}// end  public static void sendCmdlet(String command)

=======
        return line;
        }
>>>>>>> a7f4efb8f504ba01baffc83af09b11d49846f47b
