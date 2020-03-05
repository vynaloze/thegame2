package com.vynaloze.thegame2.core.content

import com.vynaloze.thegame2.core.content.property.Owner


interface Thing {
    val name: String
    val owner: Owner
}