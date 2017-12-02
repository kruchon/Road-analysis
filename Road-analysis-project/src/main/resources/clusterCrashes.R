library("rjson") 
library(cluster)

jsonData <- fromJSON(file="2016-crash.json")
jsonData <- jsonData$items

filterRegionsCondition <- sapply(jsonData, function(x) { 
    x$subject=="Московская область"&&
    x$longitude<39&
    x$longitude>38&
    x$latitude>55.5&
    x$latitude<56
})
filteredData<-jsonData[filterRegionsCondition]

data<-matrix(unlist(filteredData),nrow=length(unlist(filteredData[[1]])))
latitudes<-data[5,]
longitudes<-data[6,]
plot(longitudes,latitudes,col='black')

coords<-data.frame(latitudes,longitudes)
cl <- kmeans(coords,10, iter.max = 100)
plot(coords,col=cl$cluster)
points(cl$centers,col=1:2,pch=8,cex=2)