Unfortunately, we were unable to produce dynamic call graphs
for tradebeans and tradesoap, for the following reason.

Both benchmarks use internal timeouts for socket connections.
The instrumentation that we use to produce the call graphs
causes the benchmarks to run significantly slower (about 100x).
In result, the benchmark's timeouts are triggered, causing
the benchmarks to diverge from their usual execution paths.

We tried to work around the timeouts but failed. (See postings
to the "dacapobench-researchers" mailing list by Andreas Sewe.)