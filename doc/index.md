---
layout: page
title: Documentation
---

### Overview
1. [Intended Workflow](#intended_workflow)
2. [MDSL Example File](#example_file)
3. [General Structure](#general_structure)
4. [Global Block](#global_block)
4. [Hardware Block](#hardware_block)

### <a id="intended_workflow"></a>1. Intended Workflow

ASSIST is best suited for the following workflow:

1. Specify your hardware and software architecture in an **mdsl** file
2. Specify your resource and safety requirements in an **mdsl** file
3. Generate a set of spatial deployments (*mappings*)
4. Sort these deployments according to customized metrics
5. Select an optimal deployment

The following sections describe possible specifications for an **mdsl** file.

### <a id="example_file"></a>2. MDSL Example File



{% highlight conf %}
Global { 
	System name = "Example System";
}

Hardware {
	Compartment C1 { 
		Side = "Left";
		Zone = "Front";
		
		Box Box1{
			Manufacturer = "ACME";

			Board B1 {
				Design assurance level = A;
				Processor P1 {
					Core C1 {
						Capacity = 100;
						Architecture = "x86";
					}
				}
		
				I/O adapter {
					type = Custom-Type-1;
					count = 3;
					protection-level = L3; 
				}
			}
	
			Board B2 {
				Processor P1 {
					Core C1 {
						Capacity = 100;
					}
				}

				I/O adapter {
					type = Custom-Type-1;
					count = 3;
					protection-level = L1; 
				}
			}
		}
	}
}

Software {

	Application A1 {
		Core-utilization = 10;
		Criticality level = A;
		Required IO protection = L1;
		Requires 5 Custom-Type-1 adapter exclusive; 
	}
	
	Application A2 {
		Core-utilization = 10;
	}
}

Relations {
	A1, A2 dislocal up to Board;
}

{% endhighlight %}

### <a id="general_structure"></a>3. General structure

An **mdsl** file consists of four basic blocks.

{% highlight conf %}
Global {
  ... 
}

Hardware {
  ... 
}

Software {
  ...
}

Relations {
  ...
}
{% endhighlight %}

Please note:

* the order of the blocks matters 
* the "Relations" block is optional
* you can use the content assist and automatic code completion features for possible and allowed specifications by hitting **CTRL+Space**


### <a id="global_block"></a>4. Global Block

This block is used to specify global parameters and settings. Currently, this can be used to define the name of the system.

Example:

{% highlight C %}
Global {
	System name = "System A";
}
{% endhighlight %}

### <a id="hardware_block"></a>5. Hardware Block

Text
