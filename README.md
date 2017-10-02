# About

This repository contains the source code for the following posts:

* [Spring Batch Vs Easy Batch: Features Comparison](http://benas.github.io/2014/03/03/spring-batch-vs-easy-batch-a-hello-world-comparison.html)
* [Spring Batch Vs Easy Batch: Performance Comparison](http://benas.github.io/2015/02/15/spring-batch-vs-easy-batch-a-performance-comparison.html)

# How to run the benchmark?

The benchmark uses the following versions:

* Easy Batch: 4.0.0
* Spring Batch: 3.0.6.RELEASE

First, clone the repository and build the project:

`$>git clone https://github.com/benas/springbatch-vs-easybatch.git`

`$>cd springbatch-vs-easybatch`

`$>mvn install`

### 1. Generate input data

The `common.CustomerGenerator` class will generate X customers in the `java.io.tmpdir` directory. You can specify
the number of customers to generate with the following commands:

`$>cd common`

`$>cd target`

`$>java -Dorg.easybatch.bench.count=10000 -cp "sb-vs-eb-common-1.0.jar:dependency/*" common.CustomerGenerator`

This will generate a `customers.csv` file with 10000 random records in the `java.io.tmpdir` directory.

### 2. Run Easy Batch application

In order to launch Easy Batch application to process the previously generated customers file,
 proceed as follows **from the root directory** of the project:

`$>cd easy-batch`

`$>cd target`

`$>time java -cp "sb-vs-eb-easybatch-1.0.jar:dependency/*" easybatch.EasyBatchBenchLauncher`

This should print out the execution time of the application.

### 3. Run Spring Batch application

In order to launch Spring Batch application to process the previously generated customers file,
 proceed as follows **from the root directory** of the project:

`$>cd spring-batch`

`$>cd target`

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
