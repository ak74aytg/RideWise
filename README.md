# RideWise

RideWise is a small Java console application that models the core flow of a ride-hailing service: registering riders and drivers, tracking driver availability and locations, matching a rider with a driver, calculating a fare, and notifying observers when a ride changes state.

The project is implemented as a lightweight in-memory example. It has no database, web server, external dependencies, Maven project, or Gradle project.

## Features

- Register riders with a starting location.
- Register drivers with a vehicle type.
- Update driver locations and availability.
- List available drivers.
- Match rides with either:
  - `NearestDriverStrategy`, which selects the closest available driver.
  - `LeastActiveDriverStrategy`, which selects the driver with the oldest ride timestamp.
- Calculate fares with default and peak-hour fare strategies.
- Notify admin and security observers when a ride status changes.
- Validate user names and locations with custom exceptions.

## Project structure

```text
src/
├── Main.java
├── model/                 Domain objects and enums
├── service/               Rider, driver, and ride operations
├── strategy/
│   ├── fareStrategy/      Fare calculation strategies and factory
│   └── riderStrategy/     Driver matching strategies
├── observer/              Ride status observers
├── helper/                Distance calculation and ID generation
└── exception/             Domain validation exceptions
```

The application entry point is [`src/Main.java`](src/Main.java). It registers one rider and five drivers, updates driver state, requests a ride using the nearest-driver strategy, and completes the ride.

## Requirements

- Java Development Kit 21 or newer.
- A terminal or an IDE such as IntelliJ IDEA.

The IntelliJ project metadata currently references JDK 23 preview, although the source uses standard Java features and is intended to run on a current JDK.

## Build and run

There is currently no build-tool configuration, so the sources can be compiled directly:

```bash
mkdir -p out
javac -d out $(find src -name '*.java')
java -cp out Main
```

You can also open the folder as an IntelliJ IDEA project and run `Main`.

## Current build status

At the time this README was written, the source does not compile on Java 21 because `Driver` assigns `this.vehicle` before invoking `super(name)`. In Java, the superclass constructor must be the first statement in a constructor. Move `super(name);` before the vehicle assignment in `src/model/Driver.java` before using the commands above.

## Ride flow

1. `RiderService.registerRider` validates the rider name and location, then stores the rider in memory.
2. `DriverService.registerDriver` validates the driver name and stores the driver.
3. `DriverService.updateLocation` and `updateAvailability` prepare drivers for matching.
4. `RideService.requestRide` creates a ride, attaches the admin and security observers, and delegates driver selection to the configured matching strategy.
5. The selected driver is assigned and the ride distance is calculated using Euclidean distance between the rider and driver coordinates.
6. `RideService.completeRide` calculates a default fare before 18:00 and a peak fare from 18:00 onward, then marks the ride as completed.

## Fare calculation

Fares are based on ride distance:

| Time period | Strategy | Rate |
| --- | --- | ---: |
| Before 18:00 | `DefaultFareStrategy` | 10 per distance unit |
| 18:00 onward | `PeakHourFareStrategy` | 30 per distance unit |

`FairFactory` selects the strategy using the names `default` and `peak`.

## Known limitations

- State is held in static lists and is lost when the process exits.
- There is no persistence, authentication, API layer, or user interface.
- A ride request with no suitable driver can result in a null-driver failure rather than a domain-specific error.
- Driver location and vehicle type are not fully validated when drivers are registered or updated.
- Ride completion does not update the driver's availability or `lastRide` timestamp.
- IDs are generated randomly in memory.
- The source contains a few naming typos, including `FairReciept` and `getFairFactor`.

## Design patterns demonstrated

- Strategy pattern for driver matching and fare calculation.
- Factory pattern in `FairFactory` for selecting fare strategies.
- Observer pattern for ride status notifications to admin and security observers.

