package com.zhan.core

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 *  @author:  hyzhan
 *  @date:    2019/9/26
 *  @desc:    TODO
 */
class PropertyDelegate<T>(private val getter: () -> T,private val setter: (T) -> Unit) :
    ReadWriteProperty<Any, T> {

    override fun getValue(thisRef: Any, property: KProperty<*>): T = getter()

    override fun setValue(thisRef: Any, property: KProperty<*>, value: T) = setter.invoke(value)
}