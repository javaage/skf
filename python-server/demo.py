# -*- coding: utf-8 -*-
from flask import Flask
from flask import request
import json
import logging
from logging.handlers import TimedRotatingFileHandler
import traceback
import decimal
import numpy as np
from dnn_app_utils_v2MS import *
from GrassFilterLibraryMS import GrassFilterLibrary as GFL

app = Flask(__name__)

def sum_func(l):
    try:
        if False == isinstance(l, list):
            logging.debug("sum_func param error!!!!!")
            err = "sum_func param error!!!!!"
            return None, err
        result = 0
        for i in l:
            result += i
        logging.debug(result)
        return result, ""
    except Exception as e:
        logging.exception(e)
        return None, traceback.format_exc()

def prod_func(l):
    try:
        if False == isinstance(l, list):
            logging.debug("prod_func param error!!!!!")
            err = "prod_func param error!!!!!"
            return None, err
        result = 1
        for i in l:
            result *= i
        logging.debug(result)
        return result, ""
    except Exception as e:
        logging.exception(e)
        return None, traceback.format_exc()

@app.route('/',methods=['POSt', 'GET'])
def home():
    return '<h1>Home</h1>'

@app.route('/test_func',methods=['POST'])
def test_func():
    try:
        params = request.get_json()
        print(params)
        rawData = request.get_json()['rawData']
        scale = request.get_json()['scale']
        bpfi = request.get_json()['bpfi']
        bpfo = request.get_json()['bpfo']
        bsf = request.get_json()['bsf']
        logging.debug(rawData)
        logging.debug(scale)
        logging.debug(bpfi)
        logging.debug(bpfo)
        logging.debug(bsf)
        result = {}
        if(bpfi >= bpfo and bpfi >= bsf):
            result["catelog"] = "BPFI"
        if(bpfo >= bpfi and bpfo >= bsf):
            result["catelog"] = "BPFO"
        if(bsf >= bpfi and bsf >= bpfo):
            result["catelog"] = "BSF"
        decimal.getcontext().rounding=decimal.ROUND_HALF_UP
        result["possible"] = float(decimal.Decimal(sum(rawData) / len(rawData),decimal.getcontext()).__round__(1))
        result["basicOrder"] = max(rawData)
        result["env1"] = min(rawData)
        result["env2"] = 0
        result["env3"] = 0
        result["env4"] = 0
        result["env5"] = 0
        result["add1"] = 0
        result["add2"] = 0
        result["add3"] = 0
        result["add4"] = 0
        result["add5"] = 0
        
#         ret, err = sum_func(rawData)
#         if(None == ret):
#             return err
#         result.append(ret)
#         ret, err = prod_func(rawData)
#         if(None == ret):
#             return err
#         result.append(ret)
# #         result.append(sum_func(param_list))
# #         result.append(prod_func(param_list))
#         logging.debug(result)

        rval = json.dumps(result)
        return rval
    except Exception as e:
        logging.exception(e)
#         return 'error was occured!!!!!'
        return traceback.format_exc()

@app.route('/test_ms_func',methods=['POST'])
def test_ms_func():
    try:
        EndFreq = request.get_json()['EndFreq']
        logging.debug(EndFreq)
        SpectraLines = request.get_json()['SpectraLines']
        logging.debug(SpectraLines)
        FreqRotation = request.get_json()['FreqRotation']
        logging.debug(FreqRotation)
        ScaleFactor = request.get_json()['ScaleFactor']
        logging.debug(ScaleFactor)
        RawData = np.array(request.get_json()['RawData'])
        if(RawData.shape[0] != SpectraLines):
            return 'RawData.shape[0] != SpectraLines, [%d,%d]' % (RawData.shape[0], SpectraLines)
        logging.debug(RawData)
        BP = np.array(request.get_json()['BP'])
        if(BP.shape[0] != 3):
            return 'BP.shape[0] != 3, [%d]' % (BP.shape[0])        
        logging.debug(BP)
        BearingDangerLevel = request.get_json()['BearingDangerLevel']
        logging.debug(BearingDangerLevel)
        TotalValueDangerLevel = request.get_json()['TotalValueDangerLevel']
        logging.debug(TotalValueDangerLevel)
        DefectFreqMonitoringRange = request.get_json()['DefectFreqMonitoringRange']
        logging.debug(DefectFreqMonitoringRange)
        
        DefectFreqOrder, ENV1X, ENV2X, ENV3X, ENV4X, ENV5X, BearingTotalValue, ifBearingTotalValueAlarm, Score, Class = GFL.MSFunction(EndFreq, SpectraLines, FreqRotation, ScaleFactor, RawData, BP, BearingDangerLevel, TotalValueDangerLevel, DefectFreqMonitoringRange)
        print(DefectFreqOrder, ENV1X, ENV2X, ENV3X, ENV4X, ENV5X, BearingTotalValue, ifBearingTotalValueAlarm, Score, Class)
        
        result = {}
        result["DefectFreqOrder"] = DefectFreqOrder
        result["ENV1X"] = ENV1X 
        result["ENV2X"] = ENV2X 
        result["ENV3X"] = ENV3X
        result["ENV4X"] = ENV4X
        result["ENV5X"] = ENV5X
        result["BearingTotalValue"] = BearingTotalValue
        result["ifBearingTotalValueAlarm"] = ifBearingTotalValueAlarm
        result["Score"] = Score
        result["Class"] = Class
        logging.debug(result)
        return json.dumps(result)

    except Exception as e:
        logging.exception(e)
#         return 'error was occured!!!!!'
        return traceback.format_exc()
        

if __name__ == '__main__':
    root = logging.getLogger()  
    if len(root.handlers) == 0: #avoid the same handler
        level = logging.DEBUG
        filename = "./log_dbg"
        format='%(asctime)s %(filename)s[line:%(lineno)d] %(levelname)s %(message)s'
        hdlr = TimedRotatingFileHandler(filename, 'MIDNIGHT', 1, 7)
        fmt = logging.Formatter(format)
        hdlr.setFormatter(fmt)
        root.addHandler(hdlr)
        root.setLevel(level)
    app.run(host = "0.0.0.0", port = 8989)