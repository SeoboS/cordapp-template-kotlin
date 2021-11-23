package com.template.states

import com.template.contracts.AppleStampContract
import net.corda.core.contracts.BelongsToContract
import net.corda.core.contracts.LinearState
import net.corda.core.contracts.UniqueIdentifier
import net.corda.core.identity.AbstractParty
import net.corda.core.identity.Party
import net.corda.core.serialization.ConstructorForDeserialization

//In Java, .class gives the Class object which contains class metadata
//In Kotling ::class gives a KClass.  ::class.java gives class
@BelongsToContract(AppleStampContract::class)
data class AppleStamp @ConstructorForDeserialization constructor(
    private val stampDesc : String,
    private val issuer : Party,
    private val holder : Party,
    override val linearId : UniqueIdentifier,
    override val participants : List<AbstractParty> = listOf(issuer,holder)
    ) : LinearState {



}