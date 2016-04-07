package au.com.tilbrook.mixedlang;

import io.realm.RealmObject;

/**
 * Created by Mitchell Tilbrook on 7/04/16.
 */
public class CatModel extends RealmObject {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(final int age) {
        this.age = age;
    }
}
