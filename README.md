# About

This repository contains the source code for the following posts:

* [Easy Batch vs Spring Batch: Feature comparison](https://github.com/benas/easy-batch-vs-spring-batch/issues/1)
* [Easy Batch vs Spring Batch: Performance comparison](https://github.com/benas/easy-batch-vs-spring-batch/issues/2)

# How to run the benchmark?

The benchmark uses the following versions:

* Easy Batch: 5.2.0
* Spring Batch: 3.0.8.RELEASE

First, clone the repository and build the project:

`$>git clone https://github.com/benas/easy-batch-vs-spring-batch.git`

`$>cd easy-batch-vs-spring-batch`

`$>mvn install`

### 1. Generate input data

The `common.CustomerGenerator` class will generate X customers in the `java.io.tmpdir` directory. You can specify
the number of customers to generate with the following commands:

`$>cd common/target`

`$>java -Dorg.easybatch.bench.count=10000 -cp "sb-vs-eb-common-1.0.jar:dependency/*" common.CustomerGenerator`

This will generate a `customers.csv` file with 10000 random records in the `java.io.tmpdir` directory.

### 2. Run Easy Batch application

In order to launch Easy Batch application to process the previously generated customers file,
 proceed as follows **from the root directory** of the project:

`$>cd easy-batch/target`

`$>time java -cp "sb-vs-eb-easybatch-1.0.jar:dependency/*" easybatch.EasyBatchBenchLauncher`

This should print out the execution time of the application.

### 3. Run Spring Batch application

In order to launch Spring Batch application to process the previously generated customers file,
 proceed as follows **from the root directory** of the project:

`$>cd spring-batch/target`

`$>time java -cp "sb-vs-eb-springbatch-1.0.jar:dependency/*" springbatch.SpringBatchBenchLauncher`

This should print out the execution time of the application.

#### Notes

If you are using MS Windows, please use the `;` classpath separator in the previous commands as follows:

`$>java -Dorg.easybatch.bench.count=10000 -cp "sb-vs-eb-common-1.0.jar;dependency/*" common.CustomerGenerator`

`$>time java -cp "sb-vs-eb-easybatch-1.0.jar;dependency/*" easybatch.EasyBatchBenchLauncher`

`$>time java -cp "sb-vs-eb-springbatch-1.0.jar;dependency/*" springbatch.SpringBatchBenchLauncher`

Also, you need to use a command equivalent to `time` in order to measure the application execution time.
If you have Power Shell, you can use the `Measure-Command` command. For example:

`Measure-Command {java -cp "sb-vs-eb-easybatch-1.0.jar;dependency/*" easybatch.EasyBatchBenchLauncher}`
