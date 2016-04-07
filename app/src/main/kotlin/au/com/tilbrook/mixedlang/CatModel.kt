package au.com.tilbrook.mixedlang

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/**
 * Created by Mitchell Tilbrook on 7/04/16.
 */
public open class CatModel : RealmObject() {
    @PrimaryKey public open var name: String? = null
    public open var age: Int? = 0
}