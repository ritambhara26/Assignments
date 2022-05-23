package com.example.ques7.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.support.ClassifierCompositeItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.ques7.classifer.StudentClassifer;
import com.example.ques7.model.Student;
import com.example.ques7.processor.StudentItemProcessor;
import com.example.ques7.reader.CurrentReader;
import com.example.ques7.reader.DeltaReader;
import com.example.ques7.reader.PreviousReader;
import com.example.ques7.writer.DeltaWriter;
import com.example.ques7.writer.PreviousWriter;
import com.example.ques7.writer.RejectWriter;
import com.example.ques7.writer.SuccessWriter;


@Configuration
@EnableBatchProcessing
public class BatchConfiguration {
     @Autowired
     private JobBuilderFactory jobbuilderfactory;
     @Autowired
     private StepBuilderFactory stepbuilderfactory;
    
      @Bean
      public ClassifierCompositeItemWriter<Student> classifier(){
    	  ClassifierCompositeItemWriter<Student> writer=new ClassifierCompositeItemWriter<>();
    	  writer.setClassifier(new StudentClassifer(successwriter(),rejectwriter()));
    	  return writer;
      }
    
      @Bean
    public SuccessWriter successwriter() {
    	return new SuccessWriter();
    }
      @Bean
     public RejectWriter rejectwriter() {
    	 return new RejectWriter();
     }
     
      @Bean
     public DeltaWriter deltawriter() {
    	 return new DeltaWriter();
     }
    
      @Bean
    public PreviousReader previouswriter() {
    	return new PreviousReader();
    }
     
      @Bean
      public CurrentReader currentreader() {
    	  return new CurrentReader();
      }
     
      @Bean
     public DeltaReader deltareader() {
    	 return new DeltaReader();
     }
    
    
    
     @Bean
     public Step step1() {
    	 return stepbuilderfactory.get("previousread")
    			 .<Student,Student>chunk(10)
    			 .reader(previouswriter())
    			 .writer(new PreviousWriter())
    			 .build();
     }
     @Bean
     public Step step2() {
    	 return stepbuilderfactory
    			 .get("currentread")
    			 .<Student,Student>chunk(10)
    			 .reader(currentreader())
    			 .processor(new StudentItemProcessor())
    			 .writer(deltawriter())
    			 .build();
     }
     @Bean
     public Step step3() {
    	 return stepbuilderfactory
    			 .get("WriterClassifierstep")
    			 .<Student,Student>chunk(10)
    			 .reader(deltareader())
    			 .writer(classifier())
    			 .stream(successwriter())
    			 .stream(rejectwriter())
    			 .build();
     }
     @Bean
     public Job job() {
    	 return jobbuilderfactory
    			 .get("deltajob")
    			 .incrementer(new RunIdIncrementer())
    			 .flow(step1())
    			 .next(step2())
    			 .next(step3())
    			 .end()
    			 .build();
     }
}