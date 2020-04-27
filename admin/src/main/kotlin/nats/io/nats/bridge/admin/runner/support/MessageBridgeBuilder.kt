package nats.io.nats.bridge.admin.runner.support

import io.nats.bridge.MessageBridge
import io.nats.bridge.support.MessageBridgeImpl
import io.nats.bridge.support.MessageBusBuilder


class MessageBridgeBuilder {

    var sourceBusBuilder: MessageBusBuilder? = null
    var destBusBuilder: MessageBusBuilder? = null
    var requestReply: Boolean = true
    var name: String = "NO_NAME"


    fun withSourceBusBuilder(sourceBusBuilder: MessageBusBuilder?) = apply { this.sourceBusBuilder = sourceBusBuilder }
    fun withDestinationBusBuilder(destBusBuilder: MessageBusBuilder?) = apply { this.destBusBuilder = destBusBuilder }
    fun withRequestReply(requestReply: Boolean) = apply { this.requestReply = requestReply }
    fun withName(name: String) = apply { this.name = name }

    fun build(): MessageBridge {
        return MessageBridgeImpl(name, sourceBusBuilder!!.build(), destBusBuilder!!.build(), requestReply, null)
    }

}