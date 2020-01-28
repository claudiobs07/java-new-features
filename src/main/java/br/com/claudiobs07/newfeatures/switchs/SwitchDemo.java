package br.com.claudiobs07.newfeatures.switchs;

public class SwitchDemo {

    // 12 preview

    public static int getValueViaArrow(String mode) {
        return switch (mode) {
            case "a", "b" -> 1;
            case "c" -> 2;
            case "d", "e", "f" -> 3;
            default -> -1;
        };
    }

    //13 preview

    public static int getValueViaYield(String mode) {
        return switch (mode) {
            case "a", "b":
                yield 1;
            case "c":
                yield 2;
            case "d", "e", "f":
                yield 3;
            default:
                yield -1;
        };
    }

    // before 12

//    public int getValueViaBreak(String mode) {
//        int result = switch (mode) {
//            case "a":
//            case "b":
//                break 1;
//            case "c":
//                break 2;
//            case "d":
//            case "e":
//            case "f":
//                break 3;
//            default:
//                break -1;
//        };
//        return result;
//    }

}
