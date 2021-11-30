import java.util.ArrayList;

class Main
{
    public static void main(String[] args)
    {
        RSA rsa = new RSA();

        String text = TextDriver.ReadText("messages/Input.txt");

        ArrayList<String> encodeResult = rsa.Encode(text);
        TextDriver.WriteArrayText("messages/Encode.txt", encodeResult);

        ArrayList<String> input = TextDriver.ReadArrayText("messages/Encode.txt");

        String decodeResult = rsa.Decode(input);
        TextDriver.WriteText("messages/Decode.txt", decodeResult);
    }
}