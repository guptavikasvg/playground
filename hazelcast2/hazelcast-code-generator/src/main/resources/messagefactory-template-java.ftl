package com.hazelcast.client.impl.protocol;


import com.hazelcast.instance.Node;
import com.hazelcast.nio.Connection;
import com.hazelcast.client.impl.protocol.task.MessageTask;
import com.hazelcast.client.impl.protocol.task.NoSuchMessageTask;


public class MessageTaskFactoryImpl implements MessageTaskFactory {

    private final MessageTaskFactory[] tasks = new MessageTaskFactory[Short.MAX_VALUE];

    private final Node node;

    public MessageTaskFactoryImpl(Node node) {
        this.node = node;
        initFactories();
    }

    public void initFactories() {
<#assign package_keys = model?keys>
<#list package_keys as package_key>
//region ----------  REGISTRATION FOR ${package_key}
<#assign map = model[package_key]>
<#assign keys = map?keys>
<#list keys as key>
        tasks[${key}.TYPE.id()] = new MessageTaskFactory() {
            public MessageTask create(ClientMessage clientMessage, Connection connection) {
                return new ${map[key]}(clientMessage, node, connection);
            }
        };
</#list>
//endregion
</#list>

    }

    @Override
    public MessageTask create(ClientMessage clientMessage, Connection connection) {
        try{
            final MessageTaskFactory factory = tasks[clientMessage.getMessageType()];
            if (factory != null) {
                return factory.create(clientMessage, connection);
            }
        } catch(Exception e) {
        }
        return new NoSuchMessageTask(clientMessage, node, connection);
    }

}


