package upm.oeg.wsld.jena;

import java.io.InputStream;

import org.apache.jena.ontology.Individual;
import org.apache.jena.ontology.OntClass;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.util.FileManager;
import org.apache.jena.util.iterator.ExtendedIterator;

/**
 * Task 07: Querying ontologies (RDFs)
 * @author elozano
 * @author isantana
 *
 */
public class Task07
{
	public static String ns = "http://somewhere#";
	
	public static void main(String args[])
	{
		String filename = "resources/example6.rdf";
		Individual aux1;
		OntClass aux2;
		// Create an empty model
		OntModel model = ModelFactory.createOntologyModel(OntModelSpec.RDFS_MEM);
		
		// Use the FileManager to find the input file
		InputStream in = FileManager.get().open(filename);
	
		if (in == null)
			throw new IllegalArgumentException("File: "+filename+" not found");
	
		// Read the RDF/XML file
		model.read(in, null);
		
		
		// ** TASK 7.1: List all individuals of "Person" **
		
		OntClass person = model.getOntClass(ns+"Person");
		ExtendedIterator instances = person.listInstances();
		System.out.println("Person List \n");
		while(instances.hasNext()) {
			aux1 = (Individual) instances.next();
			
			System.out.println(aux1.getURI());
		}
		// ** TASK 7.2: List all subclasses of "Person" **
		System.out.println("List all subclasses of \"Person\"");
		ExtendedIterator subclasses = person.listSubClasses();
		
		while(subclasses.hasNext()) {
			OntClass subClass = (OntClass) subclasses.next();
			System.out.println(subClass.getURI());
		}
		
		// ** TASK 7.3: Make the necessary changes to get as well indirect instances and subclasses. TIP: you need some inference... **
	
		
		OntModel modelINF = ModelFactory.createOntologyModel(OntModelSpec.RDFS_MEM_RDFS_INF,model);
		System.out.println("New OntClass");
		OntClass auxPerson = modelINF.getOntClass(ns+"Person");
	
		ExtendedIterator auxPersonIt= auxPerson.listInstances();
		System.out.println("Person List");
		while(auxPersonIt.hasNext()){
		      Individual personInstance = (Individual) auxPersonIt.next();      
		      System.out.println("Individuo: "+ personInstance.getLocalName());
		    }    
		
		ExtendedIterator auxPersonSc = auxPerson.listSubClasses();  
	    System.out.println("SubClasses List");
	    while(auxPersonSc.hasNext()){
	      OntClass subClass = (OntClass) auxPersonSc.next();      
	      System.out.println("Subclase: "+ subClass.getLocalName());
	    }
	}
}