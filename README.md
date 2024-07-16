### Central Service to play with Logs: CentralizedLoggingService
### Request creating service: Service1
### Service to be called internally for service1: Service2

**Steps:**

1. Create docker compose files as per need configs (clone for simplicity...)
```
demo/
├── elk-docker-compose.yml
├── kafka-docker-compose.yml
└── logstash/
    └── pipeline/
        └── pipeline.conf
```

2. Run docker compose files

```shell
 docker-compose -f kafka-docker-compose.yml -f elk-docker-compose.yml up -d
```

<img width="643" alt="image" src="https://github.com/SatyaRajAwasth1/Centeralized-Logging-System-with-Kafka-and-ELK/assets/77236280/cdcc1647-2fab-438b-93f1-8e29c056e908">

3. Start services (service1, service2) (with kafka configs in log4j as kafka configs on compose file)

- after running hit an API call to endpoint in service1 that hits another service.

4. Start consuming kafka topics to test; or seek on kibana dashboard

   <img width="959" alt="image" src="https://github.com/SatyaRajAwasth1/Centeralized-Logging-System-with-Kafka-and-ELK/assets/77236280/6119b73e-d70f-4e71-9c52-39062022ff94">

