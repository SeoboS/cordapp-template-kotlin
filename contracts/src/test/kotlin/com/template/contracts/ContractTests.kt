package com.template.contracts

import net.corda.core.identity.CordaX500Name
import net.corda.testing.core.TestIdentity
import net.corda.testing.node.MockServices
import net.corda.testing.node.ledger
import org.junit.Test
import com.template.states.TemplateState

class ContractTests {
    private val ledgerServices: MockServices = MockServices(listOf("com.template"))
    var alice = TestIdentity(CordaX500Name("Alice", "TestLand", "US"))
    var bob = TestIdentity(CordaX500Name("Alice", "TestLand", "US"))

    @Test
    fun dummytest() {
        val state = TemplateState("Hello-World", alice.party, bob.party)
        ledgerServices.ledger {
            // Should fail bid price is equal to previous highest bid
            transaction {
                //failing transaction
                input(AppleStampContract.ID, state)
                output(AppleStampContract.ID, state)
                command(alice.publicKey, AppleStampContract.Commands.Create())
                fails()
            }
            //pass
            transaction {
                //passing transaction
                output(AppleStampContract.ID, state)
                command(alice.publicKey, AppleStampContract.Commands.Create())
                verifies()
            }
        }
    }
}