/**
 * Created by Bartuś on 25.09.2017.
 */
public enum Additives {
    ICE,LEMON,ICEandLEMON,PURE;

    public static Additives fromInteger(int x){
        switch(x){
            case 1: return  ICE;
            case 2: return LEMON;
            case 3: return  ICEandLEMON;
            case 4: return  PURE;
        }
        return null;
    }
}
