package com.template.ie.hadoop.sort;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;

/**
 * mapreduce框架
 */
public class SortService {

	/**	map将输入中的value转换成IntWritable类型，作为输出的key */
	public static class Map extends Mapper<Object, Text, IntWritable, IntWritable> {
		
		private static IntWritable data = new IntWritable();
		
		/* map函数 */
		public void map(Object key, Text value, Context context) 
				throws IOException,InterruptedException {
			String line = value.toString();
			data.set(Integer.parseInt(line));
			context.write(data, new IntWritable(1));
		}
	}
	
	/** 
	 * 1.reduce将输入的key复制到输出的value上，
	 * 2.然后根据输入的value-list中元素个数觉得key输出次数
	 * 3.用全局linenum代表key的位次(这句？)
	 */
	public static class Reduce extends Reducer<IntWritable, IntWritable, IntWritable, IntWritable> {
		
		private static IntWritable linenum = new IntWritable(1);
		
		/* reduce函数 */
		public void reduce(IntWritable key, Iterable<IntWritable> values, Context context) 
				throws IOException,InterruptedException {
			for(IntWritable val : values) {
				context.write(linenum, key);
				linenum = new IntWritable(linenum.get() + 1);
			}
		}
	}
}