package com.template.contracts

import com.template.states.AppleStamp
import com.template.states.TemplateState
import net.corda.core.contracts.CommandData
import net.corda.core.contracts.Contract
import net.corda.core.contracts.requireSingleCommand
import net.corda.core.transactions.LedgerTransaction
import net.corda.core.contracts.requireThat
// ************
// * Contract *
// ************
class AppleStampContract : Contract {
    companion object {
        val ID : String = "com.tutorial.contracts.AppleStampContract"
    }
    interface Commands : CommandData{
        class Issue : AppleStampContract.Commands
        class Redeem : AppleStampContract.Commands
    }

    override fun verify(tx: LedgerTransaction) {
        val commandData : CommandData = tx.getCommand<CommandData>(0).value
        if (commandData is AppleStampContract.Commands.Issue){
            var output : AppleStamp = tx.outputsOfType<AppleStamp>().get(0);
            requireThat {
                "This transaction should only output one AppleStamp state" using (tx.outputs.size == 1)
                "The output AppleStamp state should have clear description of the type of redeemable goods" using (!output.getStampDesc().equals(""))
            }
        } else if ( commandData is AppleStampContract.Commands.Redeem){

        } else {
            throw IllegalStateException("Incorrect type of AppleStamp Commands")
        }
        //https://docs.r3.com/en/tutorials/corda/4.8/os/build-basic-cordapp/basic-cordapp-contract.html#create-the-basketofapplescontract
    }
}