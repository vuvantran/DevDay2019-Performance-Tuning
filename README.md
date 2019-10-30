# DevDay2019-Performance-Tuning
DevDay2019 for Performance Tuning

# Kick up and run
1. Run with default setting (local DB, default ports)
    
    mvn clean spring-boot:run
2. Run with team profile
    
    mvn clean spring-boot:run -PgroupX
    
__X: is your group number__

3. Init data 

    mvn clean spring-boot:run -PgroupX,initData
    
__X: is your group number__
# Book external source
- https://api.itbook.store
- https://openlibrary.org/dev/docs/api/search
- https://www.panmacmillan.com/panmac/api-documentation
- http://api.bookmooch.com/api/search?db=bm&o=json&txt=java
- https://discover.libraryhub.jisc.ac.uk/search?format=json&title=java

