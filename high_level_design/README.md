
  
## Requirement

### High  Availability 

- The system should support billion write events per day, so that base TPS could be 13800 write/second in normal situation, and peak volume could be tripled. 
- Apache Cassandra has best write performance and scalable (*How many topics, clusters, nodes per-cluster should we plan?).
1. So the system should be highly scalable, 
2. need load balancer to disturb traffic.
3. Best write performance sql server.

### Querying & Reporting
- The raw data should able to indexed and generate reports. Reports  do not have to be real time. It generate metrics for customer on hour.
1.  Reporting data and raw data could be seperated.
2.  Reporting  data can be aggregated from raw data.
3.  Data aggregation can use scheduled job and run asynchronously.

###  Run with minimum downtime.

- Which means deployment or upgrade should be done while system is running.
1.  Use Kubernetes for cluster management, node deployment, and node recovery which enabling minimum downtime.
2. Should have multiple db as replica. 
3. Multiple nodes & clusters.
4. Load balancer to pass process correctly to the right nodes.

### have the ability to reprocess historical data in case of bugs in the processing logic.

1. Need persist raw data.
2. Integrate with cloudWatch to setup alerts.
3. Log monitoring for all services (logDNA).


  
  
## processing flow
1.  The request write starting by Customer App which request to action event API.
2.  These events are collected by Data Collector Server and published to Kafka Apache. Since Kafka is distributed and scalable, we used it as events routing which will improve the throughput system and make data collector low latency.
3.  Cluster Cassandra(aka subscriber) will receive events need to write.
4.  Cassandra send job to scheduled jobs.
5.  Processing server will jobs async, and analyze data. This processing result will store in object-relational database system (postgreSQL) which will provide rich query support for query server.
6.  Analytic App request queries to query server to provide some analyzed data.

 