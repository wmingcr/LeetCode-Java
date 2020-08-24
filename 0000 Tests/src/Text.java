//
//
//
//public class Text {
//    static StringBuilder output;
//
//    public Text(String[] operations) {
//        for (int i = 0; i < operations.length; i++) {
//            String[] operation = operations[i].split (" ");
//            if (operation[0].charAt (0) == 'I') {
//                insert (operation[1]);
//            } else if (operation[0].charAt (0) == 'D') {
//                delete (operations[i - 1].split (" "));
//            } else if (operation[0].charAt (0) == 'C') {
//                copy (operation[1]);
//            } else if (operation[0].charAt (0) == 'P') {
//                paste (operations[i - 1].split (" "));
//            } else if (i > 1 && operation[0].charAt (0) == 'U') {
//                undo (operations[i - 1].split (" "));
//            }
//        }
//    }
//
//    public static void insert(String insertString) {
//        if (output.length () + insertString.length () <= 20) {
//            output.append (insertString);
//        } else {
//            output.append (insertString.substring (0, 20 - output.length () - 1));
//        }
//    }
//
//    public static void delete(String[] previousString) {
////        this.output ????
//        output.delete (output.length () - previousString[1].length (), output.length ());
//    }
//
//    public static String copy(String stringIndex) {
//        int idx = Integer.parseInt (stringIndex);
//        return output.substring (idx);
//    }
//
//    public static void paste(String[] copyString) {
//        output.append (copy (copyString[1]));
//    }
//
//    public static void undo(String[] undoOperation) {
//        String insertString = undoOperation[1];
//        if (undoOperation[0].charAt (0) == 'I') {
//            output.delete (output.length () - insertString.length ());
//        } else if (undoOperation[0].charAt (0) == 'D') {
//            output.append (undoOperation[1]);
//        } else if (undoOperation[0].charAt (0) == 'P') {
//            output.
//        }
//    }
//
//    public static void main(String[] args) {
//
//
//    }
//
//}
