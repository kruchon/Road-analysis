library("rjson") 
library(cluster)
setwd("C:/Users/111/Desktop/Новая папка (3)/Road-analysis/Road-analysis-project/src/main/resources")
jsonData <- fromJSON(file="2016-crash.json")
jsonData <- jsonData$items

filterRegionsCondition <- sapply(jsonData, function(x) { 
    x$subject=="Московская область"&
    x$longitude<39&
    x$longitude>38&
    x$latitude>55.5&
    x$latitude<56
})
filteredData<-jsonData[filterRegionsCondition]

data<-matrix(unlist(filteredData),nrow=length(unlist(filteredData[[1]])))
emTypeName<-data[1,]
latitudes<-data[5,]
longitudes<-data[6,]
plot(longitudes,latitudes,col='black')
accidents<-data.frame(latitudes,longitudes,emTypeName)
cl <- kmeans(data.frame(accidents$longitudes,accidents$latitudes),300, iter.max = 100)
plot(longitudes,latitudes,col=cl$cluster)
smallClusters<-with(cl,which(size<5,arr.ind = TRUE))
reasons<-table(cl$cluster,emTypeName)
reasons<-reasons[-smallClusters,]