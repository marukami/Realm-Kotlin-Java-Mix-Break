package au.com.tilbrook.mixedlang

import io.realm.RealmObject

/**
 * Created by Mitchell Tilbrook on 7/04/16.
 */
public open class CatModel : RealmObject() {
    public open var name: String? = null
    public open var age: Int? = 0
}