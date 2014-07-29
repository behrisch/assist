package ch.hilbri.assist.mapping.tests.results;

import ch.hilbri.assist.datamodel.model.AssistModel;
import ch.hilbri.assist.datamodel.model.DesignAssuranceLevelType;
import ch.hilbri.assist.datamodel.model.HardwareArchitectureLevelType;
import ch.hilbri.assist.datamodel.model.IOAdapterProtectionLevelType;
import ch.hilbri.assist.datamodel.model.ModelPackage;
import ch.hilbri.assist.datamodel.result.mapping.Application;
import ch.hilbri.assist.datamodel.result.mapping.Board;
import ch.hilbri.assist.datamodel.result.mapping.Box;
import ch.hilbri.assist.datamodel.result.mapping.Compartment;
import ch.hilbri.assist.datamodel.result.mapping.Core;
import ch.hilbri.assist.datamodel.result.mapping.HardwareElement;
import ch.hilbri.assist.datamodel.result.mapping.Processor;
import ch.hilbri.assist.datamodel.result.mapping.Result;
import ch.hilbri.assist.mapping.datamodel.PostProcessor;
import ch.hilbri.assist.mapping.solver.SearchType;
import ch.hilbri.assist.mapping.solver.SolverJob;
import ch.hilbri.assist.mapping.tests.helpers.MyTestingMonitor;
import ch.hilbri.assist.mappingdsl.MappingDSLInjectorProvider;
import com.google.inject.Inject;
import java.util.ArrayList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

@InjectWith(MappingDSLInjectorProvider.class)
@RunWith(XtextRunner.class)
@SuppressWarnings("all")
public class MultipleResultsTests {
  private String input = new Function0<String>() {
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Global {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("System name = \"Simple System\";");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("Hardware {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Compartment C1 {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("Manufacturer = \"CompartmentManufacturer1\";");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("Power supply = \"CompartmentPowerSupply1\";");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("Side\t\t = \"CompartmentSide1\";");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("Zone\t\t = \"CompartmentZone1\";");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("Box Box1 {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("Manufacturer = \"BoxManufacturer1\";");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("Board Board1 {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("Manufacturer = \"Board Vendor 1\";");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("Type\t\t = \"BoardType1\";");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("Power supply = \"BoardPowerSupply1\";");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("Design assurance level = C;");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t\t");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("Processor Processor1 {");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("Manufacturer = \"Freescale1\";");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("Type = \"MPC55541\";");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("Core Core1 {");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("Capacity = 101;   ");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("Architecture = \"e200z61\";");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("RAM capacity = 123451;");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("ROM capacity = 678901;");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Compartment C2 {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("Manufacturer = \"CompartmentManufacturer2\";");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("Power supply = \"CompartmentPowerSupply2\";");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("Side\t\t = \"CompartmentSide2\";");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("Zone\t\t = \"CompartmentZone2\";");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("Box Box2 {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("Manufacturer = \"BoxManufacturer2\";");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("Board Board2 {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("Manufacturer = \"Board Vendor 2\";");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("Type\t\t = \"BoardType2\";");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("Power supply = \"BoardPowerSupply2\";");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("Design assurance level = D;");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t\t");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("Processor Processor2 {");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("Manufacturer = \"Freescale2\";");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("Type = \"MPC55542\";");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("Core Core2 {");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("Capacity = 102;   ");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("Architecture = \"e200z62\";");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("RAM capacity = 123452;");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("ROM capacity = 678902;");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("Software {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Application A1   {\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("Core-utilization \t\t\t= 11;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("Required RAM capacity \t\t= 12341; ");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("Required ROM capacity \t\t= 34561; ");
      _builder.newLine();
      _builder.append("\t    ");
      _builder.append("Criticality level \t\t\t= D;");
      _builder.newLine();
      _builder.append("\t    ");
      _builder.append("Required IO protection \t\t= L2;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("Identical parallel threads \t= 1;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("Developed by \t\t\t\t= \"Company A1\";");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append(" ");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Application A2   {\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("Core-utilization \t\t\t= 12;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("Required RAM capacity \t\t= 12342; ");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("Required ROM capacity \t\t= 34562; ");
      _builder.newLine();
      _builder.append("\t    ");
      _builder.append("Criticality level \t\t\t= D;");
      _builder.newLine();
      _builder.append("\t    ");
      _builder.append("Required IO protection \t\t= L3;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("Identical parallel threads \t= 1;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("Developed by \t\t\t\t= \"Company A2\";");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      return _builder.toString();
    }
  }.apply();
  
  private AssistModel model;
  
  private ArrayList<Result> allResults;
  
  @Inject
  private ParseHelper<AssistModel> parser;
  
  @BeforeClass
  public static void registerEPackage() {
    ModelPackage.eINSTANCE.eClass();
  }
  
  @Before
  public void loadModelAndCreateResults() {
    try {
      AssistModel _parse = this.parser.parse(this.input);
      this.model = ((AssistModel) _parse);
      PostProcessor.createMissingThreads(this.model);
      Assert.assertNotNull(this.model);
      final SolverJob findSolutionsJob = new SolverJob("", this.model, null);
      findSolutionsJob.setKindOfSolutions(SearchType.CONSECUTIVE);
      findSolutionsJob.setMaxSolutions(1000);
      Assert.assertNotNull(findSolutionsJob);
      MyTestingMonitor _myTestingMonitor = new MyTestingMonitor();
      findSolutionsJob.execute(_myTestingMonitor, false);
      ArrayList<Result> _newMappingResults = findSolutionsJob.getNewMappingResults();
      this.allResults = _newMappingResults;
      Assert.assertNotNull(this.allResults);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testResultCount() {
    int _size = this.allResults.size();
    Assert.assertEquals(4, _size);
  }
  
  @Test
  public void testResultAllApplicationsOnCore1() {
    Result result = null;
    for (final Result r : this.allResults) {
      boolean _and = false;
      EList<Application> _applications = r.getApplications();
      Application _get = _applications.get(0);
      EList<ch.hilbri.assist.datamodel.result.mapping.Thread> _threads = _get.getThreads();
      ch.hilbri.assist.datamodel.result.mapping.Thread _get_1 = _threads.get(0);
      Core _core = _get_1.getCore();
      String _name = _core.getName();
      boolean _equals = _name.equals("Core1");
      if (!_equals) {
        _and = false;
      } else {
        EList<Application> _applications_1 = r.getApplications();
        Application _get_2 = _applications_1.get(1);
        EList<ch.hilbri.assist.datamodel.result.mapping.Thread> _threads_1 = _get_2.getThreads();
        ch.hilbri.assist.datamodel.result.mapping.Thread _get_3 = _threads_1.get(0);
        Core _core_1 = _get_3.getCore();
        String _name_1 = _core_1.getName();
        boolean _equals_1 = _name_1.equals("Core1");
        _and = _equals_1;
      }
      if (_and) {
        result = r;
      }
    }
    Assert.assertNotNull(result);
    this.testResultStructure(result);
  }
  
  public void testResultStructure(final Result result) {
    final Result r = result;
    HardwareArchitectureLevelType _topHardwareLevel = r.getTopHardwareLevel();
    Assert.assertEquals(HardwareArchitectureLevelType.COMPARTMENT, _topHardwareLevel);
    EList<HardwareElement> _rootHardwareElements = r.getRootHardwareElements();
    int _size = _rootHardwareElements.size();
    Assert.assertEquals(2, _size);
    EList<HardwareElement> _rootHardwareElements_1 = r.getRootHardwareElements();
    HardwareElement _get = _rootHardwareElements_1.get(0);
    Assert.assertTrue((_get instanceof Compartment));
    EList<HardwareElement> _rootHardwareElements_2 = r.getRootHardwareElements();
    HardwareElement _get_1 = _rootHardwareElements_2.get(0);
    final Compartment c1 = ((Compartment) _get_1);
    String _name = c1.getName();
    Assert.assertEquals("C1", _name);
    String _manufacturer = c1.getManufacturer();
    Assert.assertEquals("CompartmentManufacturer1", _manufacturer);
    String _powerSupply = c1.getPowerSupply();
    Assert.assertEquals("CompartmentPowerSupply1", _powerSupply);
    String _side = c1.getSide();
    Assert.assertEquals("CompartmentSide1", _side);
    String _zone = c1.getZone();
    Assert.assertEquals("CompartmentZone1", _zone);
    HardwareArchitectureLevelType _hardwareLevel = c1.getHardwareLevel();
    Assert.assertEquals(HardwareArchitectureLevelType.COMPARTMENT, _hardwareLevel);
    EList<HardwareElement> _rootHardwareElements_3 = r.getRootHardwareElements();
    HardwareElement _get_2 = _rootHardwareElements_3.get(1);
    Assert.assertTrue((_get_2 instanceof Compartment));
    EList<HardwareElement> _rootHardwareElements_4 = r.getRootHardwareElements();
    HardwareElement _get_3 = _rootHardwareElements_4.get(1);
    final Compartment c2 = ((Compartment) _get_3);
    String _name_1 = c2.getName();
    Assert.assertEquals("C2", _name_1);
    String _manufacturer_1 = c2.getManufacturer();
    Assert.assertEquals("CompartmentManufacturer2", _manufacturer_1);
    String _powerSupply_1 = c2.getPowerSupply();
    Assert.assertEquals("CompartmentPowerSupply2", _powerSupply_1);
    String _side_1 = c2.getSide();
    Assert.assertEquals("CompartmentSide2", _side_1);
    String _zone_1 = c2.getZone();
    Assert.assertEquals("CompartmentZone2", _zone_1);
    HardwareArchitectureLevelType _hardwareLevel_1 = c2.getHardwareLevel();
    Assert.assertEquals(HardwareArchitectureLevelType.COMPARTMENT, _hardwareLevel_1);
    EList<Box> _boxes = c1.getBoxes();
    int _size_1 = _boxes.size();
    Assert.assertEquals(1, _size_1);
    EList<Box> _boxes_1 = c1.getBoxes();
    final Box b1 = _boxes_1.get(0);
    String _name_2 = b1.getName();
    Assert.assertEquals("Box1", _name_2);
    String _manufacturer_2 = b1.getManufacturer();
    Assert.assertEquals("BoxManufacturer1", _manufacturer_2);
    HardwareArchitectureLevelType _hardwareLevel_2 = b1.getHardwareLevel();
    Assert.assertEquals(HardwareArchitectureLevelType.BOX, _hardwareLevel_2);
    EObject _eContainer = b1.eContainer();
    Assert.assertEquals(c1, _eContainer);
    EList<Box> _boxes_2 = c2.getBoxes();
    int _size_2 = _boxes_2.size();
    Assert.assertEquals(1, _size_2);
    EList<Box> _boxes_3 = c2.getBoxes();
    final Box b2 = _boxes_3.get(0);
    String _name_3 = b2.getName();
    Assert.assertEquals("Box2", _name_3);
    String _manufacturer_3 = b2.getManufacturer();
    Assert.assertEquals("BoxManufacturer2", _manufacturer_3);
    HardwareArchitectureLevelType _hardwareLevel_3 = b2.getHardwareLevel();
    Assert.assertEquals(HardwareArchitectureLevelType.BOX, _hardwareLevel_3);
    EObject _eContainer_1 = b2.eContainer();
    Assert.assertEquals(c2, _eContainer_1);
    EList<Board> _boards = b1.getBoards();
    int _size_3 = _boards.size();
    Assert.assertEquals(1, _size_3);
    EList<Board> _boards_1 = b1.getBoards();
    final Board board1 = _boards_1.get(0);
    String _name_4 = board1.getName();
    Assert.assertEquals("Board1", _name_4);
    String _manufacturer_4 = board1.getManufacturer();
    Assert.assertEquals("Board Vendor 1", _manufacturer_4);
    String _boardType = board1.getBoardType();
    Assert.assertEquals("BoardType1", _boardType);
    String _powerSupply_2 = board1.getPowerSupply();
    Assert.assertEquals("BoardPowerSupply1", _powerSupply_2);
    DesignAssuranceLevelType _assuranceLevel = board1.getAssuranceLevel();
    Assert.assertEquals(DesignAssuranceLevelType.C, _assuranceLevel);
    int _ramCapacity = board1.getRamCapacity();
    Assert.assertEquals(123451, _ramCapacity);
    int _romCapacity = board1.getRomCapacity();
    Assert.assertEquals(678901, _romCapacity);
    HardwareArchitectureLevelType _hardwareLevel_4 = board1.getHardwareLevel();
    Assert.assertEquals(HardwareArchitectureLevelType.BOARD, _hardwareLevel_4);
    EObject _eContainer_2 = board1.eContainer();
    Assert.assertEquals(b1, _eContainer_2);
    EList<Board> _boards_2 = b2.getBoards();
    int _size_4 = _boards_2.size();
    Assert.assertEquals(1, _size_4);
    EList<Board> _boards_3 = b2.getBoards();
    final Board board2 = _boards_3.get(0);
    String _name_5 = board2.getName();
    Assert.assertEquals("Board2", _name_5);
    String _manufacturer_5 = board2.getManufacturer();
    Assert.assertEquals("Board Vendor 2", _manufacturer_5);
    String _boardType_1 = board2.getBoardType();
    Assert.assertEquals("BoardType2", _boardType_1);
    String _powerSupply_3 = board2.getPowerSupply();
    Assert.assertEquals("BoardPowerSupply2", _powerSupply_3);
    DesignAssuranceLevelType _assuranceLevel_1 = board2.getAssuranceLevel();
    Assert.assertEquals(DesignAssuranceLevelType.D, _assuranceLevel_1);
    int _ramCapacity_1 = board2.getRamCapacity();
    Assert.assertEquals(123452, _ramCapacity_1);
    int _romCapacity_1 = board2.getRomCapacity();
    Assert.assertEquals(678902, _romCapacity_1);
    HardwareArchitectureLevelType _hardwareLevel_5 = board2.getHardwareLevel();
    Assert.assertEquals(HardwareArchitectureLevelType.BOARD, _hardwareLevel_5);
    EObject _eContainer_3 = board2.eContainer();
    Assert.assertEquals(b2, _eContainer_3);
    EList<Processor> _processors = board1.getProcessors();
    int _size_5 = _processors.size();
    Assert.assertEquals(1, _size_5);
    EList<Processor> _processors_1 = board1.getProcessors();
    final Processor p1 = _processors_1.get(0);
    String _name_6 = p1.getName();
    Assert.assertEquals("Processor1", _name_6);
    String _manufacturer_6 = p1.getManufacturer();
    Assert.assertEquals("Freescale1", _manufacturer_6);
    String _processorType = p1.getProcessorType();
    Assert.assertEquals("MPC55541", _processorType);
    HardwareArchitectureLevelType _hardwareLevel_6 = p1.getHardwareLevel();
    Assert.assertEquals(HardwareArchitectureLevelType.PROCESSOR, _hardwareLevel_6);
    EObject _eContainer_4 = p1.eContainer();
    Assert.assertEquals(board1, _eContainer_4);
    EList<Processor> _processors_2 = board2.getProcessors();
    int _size_6 = _processors_2.size();
    Assert.assertEquals(1, _size_6);
    EList<Processor> _processors_3 = board2.getProcessors();
    final Processor p2 = _processors_3.get(0);
    String _name_7 = p2.getName();
    Assert.assertEquals("Processor2", _name_7);
    String _manufacturer_7 = p2.getManufacturer();
    Assert.assertEquals("Freescale2", _manufacturer_7);
    String _processorType_1 = p2.getProcessorType();
    Assert.assertEquals("MPC55542", _processorType_1);
    HardwareArchitectureLevelType _hardwareLevel_7 = p2.getHardwareLevel();
    Assert.assertEquals(HardwareArchitectureLevelType.PROCESSOR, _hardwareLevel_7);
    EObject _eContainer_5 = p2.eContainer();
    Assert.assertEquals(board2, _eContainer_5);
    EList<Core> _cores = p1.getCores();
    int _size_7 = _cores.size();
    Assert.assertEquals(1, _size_7);
    EList<Core> _cores_1 = p1.getCores();
    final Core core1 = _cores_1.get(0);
    String _name_8 = core1.getName();
    Assert.assertEquals("Core1", _name_8);
    int _capacity = core1.getCapacity();
    Assert.assertEquals(101, _capacity);
    String _architecture = core1.getArchitecture();
    Assert.assertEquals("e200z61", _architecture);
    HardwareArchitectureLevelType _hardwareLevel_8 = core1.getHardwareLevel();
    Assert.assertEquals(HardwareArchitectureLevelType.CORE, _hardwareLevel_8);
    EObject _eContainer_6 = core1.eContainer();
    Assert.assertEquals(p1, _eContainer_6);
    EList<Core> _cores_2 = p2.getCores();
    int _size_8 = _cores_2.size();
    Assert.assertEquals(1, _size_8);
    EList<Core> _cores_3 = p2.getCores();
    final Core core2 = _cores_3.get(0);
    String _name_9 = core2.getName();
    Assert.assertEquals("Core2", _name_9);
    int _capacity_1 = core2.getCapacity();
    Assert.assertEquals(102, _capacity_1);
    String _architecture_1 = core2.getArchitecture();
    Assert.assertEquals("e200z62", _architecture_1);
    HardwareArchitectureLevelType _hardwareLevel_9 = core2.getHardwareLevel();
    Assert.assertEquals(HardwareArchitectureLevelType.CORE, _hardwareLevel_9);
    EObject _eContainer_7 = core2.eContainer();
    Assert.assertEquals(p2, _eContainer_7);
    EList<ch.hilbri.assist.datamodel.model.Application> _applications = this.model.getApplications();
    int _size_9 = _applications.size();
    Assert.assertEquals(2, _size_9);
    EList<ch.hilbri.assist.datamodel.model.Application> _applications_1 = this.model.getApplications();
    final ch.hilbri.assist.datamodel.model.Application a1 = _applications_1.get(0);
    String _name_10 = a1.getName();
    Assert.assertEquals("A1", _name_10);
    int _coreUtilization = a1.getCoreUtilization();
    Assert.assertEquals(11, _coreUtilization);
    int _ramUtilization = a1.getRamUtilization();
    Assert.assertEquals(12341, _ramUtilization);
    int _romUtilization = a1.getRomUtilization();
    Assert.assertEquals(34561, _romUtilization);
    DesignAssuranceLevelType _criticalityLevel = a1.getCriticalityLevel();
    Assert.assertEquals(DesignAssuranceLevelType.D, _criticalityLevel);
    IOAdapterProtectionLevelType _ioAdapterProtectionLevel = a1.getIoAdapterProtectionLevel();
    Assert.assertEquals(IOAdapterProtectionLevelType.LEVEL_2, _ioAdapterProtectionLevel);
    String _developedBy = a1.getDevelopedBy();
    Assert.assertEquals("Company A1", _developedBy);
    EList<ch.hilbri.assist.datamodel.model.Application> _applications_2 = this.model.getApplications();
    final ch.hilbri.assist.datamodel.model.Application a2 = _applications_2.get(1);
    String _name_11 = a2.getName();
    Assert.assertEquals("A2", _name_11);
    int _coreUtilization_1 = a2.getCoreUtilization();
    Assert.assertEquals(12, _coreUtilization_1);
    int _ramUtilization_1 = a2.getRamUtilization();
    Assert.assertEquals(12342, _ramUtilization_1);
    int _romUtilization_1 = a2.getRomUtilization();
    Assert.assertEquals(34562, _romUtilization_1);
    DesignAssuranceLevelType _criticalityLevel_1 = a2.getCriticalityLevel();
    Assert.assertEquals(DesignAssuranceLevelType.D, _criticalityLevel_1);
    IOAdapterProtectionLevelType _ioAdapterProtectionLevel_1 = a2.getIoAdapterProtectionLevel();
    Assert.assertEquals(IOAdapterProtectionLevelType.LEVEL_3, _ioAdapterProtectionLevel_1);
    String _developedBy_1 = a2.getDevelopedBy();
    Assert.assertEquals("Company A2", _developedBy_1);
    EList<ch.hilbri.assist.datamodel.model.Thread> _threads = a1.getThreads();
    int _size_10 = _threads.size();
    Assert.assertEquals(1, _size_10);
    String _name_12 = a1.getName();
    String _plus = (_name_12 + "_");
    String _plus_1 = (_plus + Integer.valueOf(1));
    EList<ch.hilbri.assist.datamodel.model.Thread> _threads_1 = a1.getThreads();
    ch.hilbri.assist.datamodel.model.Thread _get_4 = _threads_1.get(0);
    String _name_13 = _get_4.getName();
    Assert.assertEquals(_plus_1, _name_13);
    int _coreUtilization_2 = a1.getCoreUtilization();
    EList<ch.hilbri.assist.datamodel.model.Thread> _threads_2 = a1.getThreads();
    ch.hilbri.assist.datamodel.model.Thread _get_5 = _threads_2.get(0);
    int _coreUtilization_3 = _get_5.getCoreUtilization();
    Assert.assertEquals(_coreUtilization_2, _coreUtilization_3);
    EList<ch.hilbri.assist.datamodel.model.Thread> _threads_3 = a1.getThreads();
    ch.hilbri.assist.datamodel.model.Thread _get_6 = _threads_3.get(0);
    EObject _eContainer_8 = _get_6.eContainer();
    Assert.assertEquals(a1, _eContainer_8);
    EList<ch.hilbri.assist.datamodel.model.Thread> _threads_4 = a2.getThreads();
    int _size_11 = _threads_4.size();
    Assert.assertEquals(1, _size_11);
    String _name_14 = a2.getName();
    String _plus_2 = (_name_14 + "_");
    String _plus_3 = (_plus_2 + Integer.valueOf(1));
    EList<ch.hilbri.assist.datamodel.model.Thread> _threads_5 = a2.getThreads();
    ch.hilbri.assist.datamodel.model.Thread _get_7 = _threads_5.get(0);
    String _name_15 = _get_7.getName();
    Assert.assertEquals(_plus_3, _name_15);
    int _coreUtilization_4 = a2.getCoreUtilization();
    EList<ch.hilbri.assist.datamodel.model.Thread> _threads_6 = a2.getThreads();
    ch.hilbri.assist.datamodel.model.Thread _get_8 = _threads_6.get(0);
    int _coreUtilization_5 = _get_8.getCoreUtilization();
    Assert.assertEquals(_coreUtilization_4, _coreUtilization_5);
    EList<ch.hilbri.assist.datamodel.model.Thread> _threads_7 = a2.getThreads();
    ch.hilbri.assist.datamodel.model.Thread _get_9 = _threads_7.get(0);
    EObject _eContainer_9 = _get_9.eContainer();
    Assert.assertEquals(a2, _eContainer_9);
  }
}
