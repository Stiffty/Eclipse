public class Cowsay {
   public static void main(String[] args) {
   
   String message = "Java rocks!";
   String upperBubble = "_____________"; // obere Begrenzung der Sprechblase
   String lowerBubble = "-------------"; // untere Begrenzung der Sprechblase
   
   if (args.length > 0) {
       message = args[0];
       upperBubble = "__";
       lowerBubble = "--";
       
       //für jeden Buchstaben, den args[0] hat: Verlängere upperBubble und lowerBubble um ein Zeichen
       for (int i = 0; i<= args[0].length(); i++) {
           upperBubble = upperBubble + "_";
           lowerBubble = lowerBubble + "-";
       }
   }
   
   System.out.println(" " + upperBubble);
   System.out.println("< " + message + "! >");
   System.out.println(" " + lowerBubble);
   System.out.println("       \\   ^__^");
   System.out.println("        \\  (oo)\\_______");
   System.out.println("           (__)\\       )\\/\\");
   System.out.println("               ||----w |");
   System.out.println("               ||     ||");
   }
}