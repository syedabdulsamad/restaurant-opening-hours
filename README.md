# Restaurant opening hours service


# Build and Run

Build project:

> mvn clean install

Build project:

> java -jar targets/resturant-opening-hours-0.0.1-SNAPSHOT.jar

## Swagger documentation

> http://localhost:8080/swagger-ui/index.html

## Formatting
If you have [ktlint](https://github.com/pinterest/ktlint) installed locally, you can simply run to get formatting:
> ktlint -F


# Part 2 - Assignment
In the current defined structure where the days appear directly appear at the first level, we have to create a request object which contains same type of data but with different name like i have done now in ``OpeningHoursInputRequest```

The better approach could be to enclose this whole structure inside another key like
```
{
	"days": {
		"monday": [{
			"type": "close",
			"value": 64800
		}],
		"tuesday": [{
			"type": "open",
			"value": 36000
		}, {
			"type": "close",
			"value": 64800
		}],
		"wednesday": [],
		"thursday": [{
				"type": "open",
				"value": 37800
			},
			{
				"type": "close",
				"value": 64800
			}],
		"friday": [],
		"saturday": [{
				"type": "close",
				"value": 3600
			},
			{
				"type": "open",
				"value": 36000
			}],
		"sunday": [{
				"type": "close",
				"value": 3600
			},
			{
				"type": "open",
				"value": 82800
			}]
	}
}
```

With the above-mentioned structure we can simply define the class ``OpeningHoursInputRequest`` as: 
```
data class OpeningHoursInputRequest(val days: Map<DaysOfWeek, List<OpeningHours>>)
```

We can get the opening hours like below and pass it to ``OpeningHoursService``:
 ```
 val allOpeningHours = days.entries.flatMap { it.value }
 ```
