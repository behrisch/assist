package ch.hilbri.assist.mapping.tests

import ch.hilbri.assist.datamodel.model.AssistModel
import ch.hilbri.assist.datamodel.model.ModelPackage
import ch.hilbri.assist.datamodel.result.mapping.Result
import ch.hilbri.assist.mapping.datamodel.PostProcessor
import ch.hilbri.assist.mapping.solver.AssistSolver
import ch.hilbri.assist.mapping.solver.SearchType
import ch.hilbri.assist.mappingdsl.MappingDSLInjectorProvider
import com.google.inject.Inject
import java.util.ArrayList
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.junit.Before
import org.junit.BeforeClass
import org.junit.runner.RunWith
import org.slf4j.Logger
import org.slf4j.LoggerFactory

import static org.junit.Assert.*
import ch.hilbri.assist.mapping.solver.exceptions.BasicConstraintsException

@InjectWith(MappingDSLInjectorProvider)
@RunWith(XtextRunner)
class AbstractMappingTest {
	
	protected String input
	protected AssistModel model
	protected ArrayList<Result> allResults
	
	private Logger logger

	new() {
		logger = LoggerFactory.getLogger(AbstractMappingTest)
	}


	@Inject
	protected ParseHelper<AssistModel> parser

	@BeforeClass
	def static void registerEPackage() { ModelPackage.eINSTANCE.eClass() }	
	
	@Before
	def void loadModelAndCreateResults() {
		/* Parse the input */
		model = parser.parse(input) as AssistModel
		
		/* Fix the model */
		PostProcessor.createMissingThreads(model);
		assertNotNull(model) 

		/* Create the job to search for new solutions */
		val solver = new AssistSolver(model)
		solver.solverSearchStrategy = SearchType.CONSECUTIVE
		solver.solverMaxSolutions = 1000
		assertNotNull(solver)
		
		/* Execute this job */
		try {
			solver.propagation
			solver.solutionSearch
		}
		catch (BasicConstraintsException e) {
			val constraintName = e.getConstraintName
			val message = e.getExplanation
			logger.info("Inconsistency found while processing constraint \"" + constraintName + "\"");
			logger.info("\""+ message + "\"");
		}

		/* Store the results */
		allResults = solver.results
		assertNotNull(allResults)
	}
}