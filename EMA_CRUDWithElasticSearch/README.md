# Employee Management System with Elastic Search

We have used Elastic Search version 2.4 as things will not work with latest version of ES which is 7.
Also note that SpringBoot version should be 1.5.1

## Reference Urls:
1) https://mkyong.com/spring-boot/spring-boot-spring-data-elasticsearch-example/
2) https://docs.spring.io/spring-data/elasticsearch/docs/current/reference/html/#elasticsearch.operations
3) https://www.journaldev.com/18148/spring-boot-elasticsearch#spring-boot-elasticsearch-6
4) https://www.baeldung.com/spring-data-elasticsearch-tutorial
5) https://dzone.com/articles/spring-boot-elasticsearch

**Note** that first worked for me and it looks best suited to me as we are using ElasticsearchRepository instead of SimpleJPARepository or CRUDRepository.
ElasticsearchRepository is finally extended with CRUDRepository. So code for elastic and JPA would be more or less same.

Just dummy work is done and not proper unit testing is applied due to time limitation.

