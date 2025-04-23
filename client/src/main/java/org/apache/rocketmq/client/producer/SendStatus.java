/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.rocketmq.client.producer;

public enum SendStatus {
    /**
     * 发送成功
     * 根据 brokerRole 和 flushDiskType 的配置
     */
    SEND_OK,
    /**
     * 刷磁盘超时、一般是 syncFlushDisk
     */
    FLUSH_DISK_TIMEOUT,
    /**
     * broker 配置为 SYNC_MASTER
     * 同步给 slave 超时
     */
    FLUSH_SLAVE_TIMEOUT,
    /**
     * Broker 配置为 同步复制（SYNC_MASTER），但当前无可用从节点。
     */
    SLAVE_NOT_AVAILABLE,
}
