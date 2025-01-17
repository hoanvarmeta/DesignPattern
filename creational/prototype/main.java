package creational.prototype;

import java.util.ArrayList;

abstract class Key {
    protected String name;
    protected String type;

    Key(String name, String type) {
        this.name = name;
        this.type = type;
    }

    Key(Key key) {
        this.name = key.name;
        this.type = key.type;
    }

    public abstract Key clone(Key key);

    public abstract void get();
}

class CarKey extends Key {

    private String smartKey;

    CarKey(Key key) {
        super(key);
        CarKey carKey = (CarKey) key;
        this.smartKey = carKey.smartKey;
    }

    CarKey(String name, String type, String smartKey) {
        super(name, type);
        this.smartKey = smartKey;
    }

    @Override
    public Key clone(Key key) {
        return new CarKey(key);
    }

    public void get() {
        System.out.println("Name : " + this.name + "Type: " + this.type + "Code: " + this.smartKey);
    }
}

class HouseKey extends Key {
    private String code;

    HouseKey(Key key) {
        super(key);
        HouseKey houseKey = (HouseKey) key;
        this.code = houseKey.code;
    }

    HouseKey(String name, String type, String code) {
        super(name, type);
        this.code = code;
    }

    @Override
    public Key clone(Key key) {
        return new HouseKey(key);
    }

    public void get() {
        System.out.println("Name : " + this.name + "Type: " + this.type + "Code: " + this.code);
    }
}

public class main {

    public static void main(String[] args) {
        ArrayList<Key> keys = new ArrayList<>();
        ArrayList<Key> newKeys = new ArrayList<>();

        keys.add(new CarKey("CarKey", "Verify", "smartKey"));
        keys.add(new HouseKey("HouseKey", "Lock", "Code"));
        for (Key key : keys) {
            newKeys.add(key.clone(key));
        }

        for (Key key : newKeys) {
            key.get();
        }
    }

}
