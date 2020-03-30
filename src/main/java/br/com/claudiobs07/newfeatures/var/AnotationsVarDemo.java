package br.com.claudiobs07.newfeatures.var;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class AnotationsVarDemo {

    public static void main(String[] args) {
        AddressOperation toAddressString = (var street, @Nullable var aptNumber, @NotNull var zip) -> street + ", apt. " + aptNumber + "  " + zip;
        String address = toAddressString.build("Wood", null, null); // a null value in attribute zip will throw error into IDE
        System.out.println(address);
    }

    @FunctionalInterface
    interface AddressOperation {
        String build(String street, Integer aptNumber, Integer zip);
    }

}
