/*******************************************************************************
 * Copyright 2014 Rafael Garcia Moreno.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package com.bladecoder.engine.actions;

import java.util.HashMap;

import com.bladecoder.engine.actions.Action;
import com.bladecoder.engine.actions.ActionCallback;
import com.bladecoder.engine.actions.Param;

import com.bladecoder.engine.actions.Param.Type;
import com.bladecoder.engine.model.Actor;
import com.bladecoder.engine.model.World;

public class SetStateAction implements Action {
	public static final String INFO = "Sets the actor state";
	public static final Param[] PARAMS = {
		new Param("state", "The actor 'state'", Type.STRING)
		};		
	
	String actorId;
	String state;
	
	@Override
	public void setParams(HashMap<String, String> params) {
		actorId = params.get("actor");
		state = params.get("state");
	}

	@Override
	public boolean run(ActionCallback cb) {
		if(actorId != null) {
			Actor actor = World.getInstance().getCurrentScene().getActor(actorId, true);
		
			actor.setState(state);
		} else {
			World.getInstance().getCurrentScene().setState(state);
		}
		
		return false;
	}


	@Override
	public String getInfo() {
		return INFO;
	}

	@Override
	public Param[] getParams() {
		return PARAMS;
	}
}
