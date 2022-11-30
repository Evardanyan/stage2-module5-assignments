package assignments;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

import assignments.annotations.FullNameProcessorGeneratorAnnotation;
import assignments.annotations.ListIteratorAnnotation;
import assignments.annotations.ReadFullProcessorNameAnnotation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocalProcessor {
    private String processorName;
    private Long period = 10_000_000_000_000L;
    protected String ProcessorVersion;
    private Integer valueOfCheap;
    Scanner informationScanner;
    static LinkedList<String> stringArrayList = new LinkedList<>();

    public LocalProcessor(String processorName, Long period, String processorVersion, Integer valueOfCheap,
                          Scanner informationscanner, LinkedList<String> stringArrayList) {
        this.processorName = processorName;
        this.period = period;
        ProcessorVersion = processorVersion;
        this.valueOfCheap = valueOfCheap;
        this.informationScanner = informationscanner;
        this.stringArrayList = stringArrayList;
    }

    public LocalProcessor() {
    }

    @ListIteratorAnnotation
    public void listIterator(LinkedList<String> stringList) {
        stringArrayList = new LinkedList<>(stringList);
        for (int i = 0; i < period; i++) {
            System.out.println(stringArrayList.get(i).hashCode());
        }
    }

    @FullNameProcessorGeneratorAnnotation
    public String fullNameProcessorGenerator(LinkedList<String> stringList) {
        for (int i = 0; i < stringArrayList.size(); i++) {
            processorName+=stringList.get(i)+' ';
        }
        return processorName;
    }

    @ReadFullProcessorNameAnnotation
    public void readFullProcessorName(File file) throws FileNotFoundException {
            informationScanner = new Scanner(file);
            while (informationScanner.hasNext()) {
                ProcessorVersion+= informationScanner.nextLine();
            }

    }
}
