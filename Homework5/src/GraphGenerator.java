import com.sun.xml.internal.bind.v2.TODO;
import homework.C;
import org.apache.bcel.Repository;
import org.apache.bcel.classfile.JavaClass;
import org.apache.bcel.classfile.Method;
import org.apache.bcel.classfile.Node;
import org.apache.bcel.classfile.Visitor;
import org.apache.bcel.generic.*;
import org.apache.bcel.generic.BranchInstruction;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class GraphGenerator {
    public CFG createCFG(String className) throws ClassNotFoundException {
        CFG cfg = new CFG();
        JavaClass jc = Repository.lookupClass(className);
        ClassGen cg = new ClassGen(jc);
        ConstantPoolGen cpg = cg.getConstantPool();
        for (Method m: cg.getMethods())
        {
            MethodGen mg = new MethodGen(m, cg.getClassName(), cpg);
            InstructionList il = mg.getInstructionList();
            InstructionHandle[] handles = il.getInstructionHandles();
            for (InstructionHandle ih: handles)
            {
                int position = ih.getPosition();
                System.out.println(position);
                cfg.addNode(position, m, jc);
                Instruction inst = ih.getInstruction();
                // your code goes here

                //check for jsr[_w] and *switch instructions
                if(!inst.toString().contains("jsr[_w]") || !inst.toString().contains("*switch")) {

                    //Add an edge to the dummy node
                    if (inst.toString().contains("return")) {

                        //Add a dummy node if one doesn't already exist
                        if (!cfg.nodes.contains(-1)) {
                            cfg.addNode(-1, m, jc);
                        }
                        cfg.addEdge(position, -1, m, jc);
                    }

                    if (!inst.toString().contains("invoke") && !inst.toString().contains("return")) {
                        //Check if the node has a target
                        if (inst.toString().contains("if")) {
                            //add the edge for the target node
                            String target = inst.toString().substring(inst.toString().length() - 1);
                            int targetNode = Integer.parseInt(target);

                            cfg.addEdge(position, targetNode, m, jc);
                        }
                        //add an edge to the node that comes after the current node
                        int nextNode = ih.getNext().getPosition();
                        cfg.addEdge(position, nextNode, m, jc);
                    }
                }

            }
        }

            System.out.println(cfg.toString());
        return cfg; }
    public CFG createCFGWithMethodInvocation(String className) throws ClassNotFoundException {
        // your code goes here
        CFG cfg = new CFG();
        JavaClass jc = Repository.lookupClass(className);
        ClassGen cg = new ClassGen(jc);
        ConstantPoolGen cpg = cg.getConstantPool();
        for (Method m: cg.getMethods())
        {
            MethodGen mg = new MethodGen(m, cg.getClassName(), cpg);
            InstructionList il = mg.getInstructionList();
            InstructionHandle[] handles = il.getInstructionHandles();
            for (InstructionHandle ih : handles) {
                int position = ih.getPosition();
                System.out.println(position);
                cfg.addNode(position, m, jc);
                Instruction inst = ih.getInstruction();

                //Add an edge to the dummy node
                if(inst.toString().contains("return"))
                {
                    //Add a dummy node if one doesn't already exist
                    if(!cfg.nodes.contains(-1))
                    {
                        cfg.addNode(-1, m, jc);
                    }
                    cfg.addEdge(position, -1, m, jc);
                }

                if (!inst.toString().contains("invokespecial") && !inst.toString().contains("return") && !inst.toString().contains("static"))
                {
                            int nextNode = ih.getNext().getPosition();
                            cfg.addEdge(position, nextNode, m, jc);

                            if(inst.toString().contains("if"))
                            {
                                String target = inst.toString().substring(inst.toString().length() - 1);
                                int targetNode = Integer.parseInt(target);
                                cfg.addEdge(position, targetNode, m, jc);
                            }
                }
            }
        }
        System.out.println(cfg.toString());
        return cfg;
    }
    public static void main(String[] a) throws ClassNotFoundException {
        GraphGenerator gg = new GraphGenerator();
        gg.createCFG("homework.C"); // example invocation of createCFG
        gg.createCFGWithMethodInvocation("homework.D"); // example invocation of createCFGWithMethodInovcation
    } }
