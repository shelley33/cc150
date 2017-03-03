package Chapter5;

/**
 * Created by bresai on 2017/2/22.
 */
public class DrawLine {
    public void drawLine(byte[] screen, int width, int x1, int x2, int y){
        int firstByte = (x1 - 1) / 8;
        int firstByteOffset = (x1 - 1) % 8;

        int lastByte = (x2 - 1) / 8;
        int lastByteOffset = (x2 - 1) % 8;

        for (int i = firstByte + 1; i < lastByte; i++){
            screen[width/8 * y + i] = (byte)0xFF;
        }

        byte firstMask = (byte)(0xFF >> firstByteOffset);
        byte lastMask = (byte)(0xFF << 8 - lastByteOffset - 1);

        if (firstByte == lastByte){
            screen[width/8 * y + firstByte] = (byte) (firstMask & lastMask);
        }else{
            screen[width/8 * y + firstByte] = firstMask;
            screen[width/8 * y + lastByte] = lastMask;
        }

    }
}
