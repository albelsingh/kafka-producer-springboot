1. Install Kafka
2. Start Zookeeper
3. Start Kafka Server
4. Create a Topic
5. Start producer & push message in topic
6. Start consumer
   
**Zookeeper:** 2181

**Kafka Server/Broker:** 9092

**Open Source Kafka Startup in local**

**1. To start apache kafka Zookeeper:**

bin/zookeeper-server-start.sh config/zookeeper.properties

**2.To start Broker:**

bin/kafka-server-start.sh config/server.properties

**3.Create topic:**

bin/kafka-topics.sh --bootstrap-server localhost:9092 --create --topic java-tp --partitions 3 --replication-factor 1

**4.List out all topic names:**

bin/kafka-topics.sh --bootstrap-server localhost:9092 --list

**5.Describe topics:**

bin/kafka-topics.sh --bootstrap-server localhost:9092  --describe java-tp

**6.To start producer:**

bin/kafka-console-producer.sh --broker-list localhost:9092 --topic java-tp

**7.To push csv file to topic:**

bin/kafka-console-producer.sh --broker-list localhost:9092 --topic java-tp </Users/albelsinghbhodeliya/Downloads/Data/customers-100.csv

**8.To start consumer:**

bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic java-tp --from-beginning


**Confluent Kafka Community Edition in Local**

**1. To start apache kafka Zookeeper:**

bin/zookeeper-server-start etc/kafka/zookeeper.properties 

**2.To start Broker:**

bin/kafka-server-start etc/kafka/server.properties

**3.Create topic:**

bin/kafka-topics --bootstrap-server localhost:9092 --create --topic confluent-tp --partitions 3 --replication-factor 1

**4.List out all topic names:**

bin/kafka-topics --bootstrap-server localhost:9092 --list

**5.Describe topics:**

bin/kafka-topics --bootstrap-server localhost:9092  --describe confluent-tp

**6.To start producer:**

bin/kafka-console-producer --broker-list localhost:9092 --topic confluent-tp

**7.To push csv file to topic:**

bin/kafka-console-producer --broker-list localhost:9092 --topic confluent-tp </Users/albelsinghbhodeliya/Downloads/Data/customers-100.csv

**8.To start consumer:**

bin/kafka-console-consumer --bootstrap-server localhost:9092 --topic confluent-tp --from-beginning
