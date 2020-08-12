public static String sendCmdlet(String cmdlet){

        //verify the cmdlet has a space at the end, and that no space precedes the argument
        cmdlet = cmdlet.trim() + " ";

        //send the command to the terminal - this page helped a lot: https://bit.ly/33PZjlB
        Process proc = null;        //define the variable outside the try-catch to avoid IDE complaints
        try {
        proc = Runtime.getRuntime().exec(cmdlet);
        }catch (Exception e){
        System.out.printf("attempted cmdlet failed");
        }

        // Read the output
        BufferedReader reader =
        new BufferedReader(new InputStreamReader(proc.getInputStream()));
        String line = "";
        try {
        while ((line = reader.readLine()) != null) {
        System.out.print(line + "\n");
        }
        }catch (Exception e){
        System.out.print("failed to read input stream");
        }// end try-catch while ((line = reader.readLine()) != null)

        try {
        proc.waitFor();
        }catch (Exception e){
        System.out.print("proc.waitfor() failed");
        }//end try-catch proc.waitFor();

        return line;
        }